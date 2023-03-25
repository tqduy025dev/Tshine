package com.tshine.server.apiserver.service.impl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.tshine.common.entities.system.SystemFile;
import com.tshine.server.apiserver.service.AmazonClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AmazonClientServiceImpl implements AmazonClientService {
    private AmazonS3 s3client;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.s3client = AmazonS3ClientBuilder
                .standard().withRegion("us-east-2")
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    @Override
    public String uploadFileToS3(MultipartFile multipartFile) throws IOException {
        File file = this.convertMultiPartToFile(multipartFile);
        String fileName = this.generateFileName(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        this.uploadFile(fileName, file);
        file.deleteOnExit();
        return s3client.getUrl(bucketName, fileName).toString();
    }

    @Override
    public List<SystemFile> uploadFileToS3(MultipartFile[] multipartFiles) throws IOException {
        List<SystemFile> systemFiles = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            String url = this.uploadFileToS3(multipartFile);
            SystemFile systemFile = new SystemFile();
            systemFile.setUrl(url);
            systemFile.setType(multipartFile.getContentType());
            systemFiles.add(systemFile);
        }
        return systemFiles;
    }


    private void uploadFile(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    private File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }


    private String generateFileName(String fileName) {
        return System.currentTimeMillis() + fileName.replaceAll(" ", "_");
    }


}
