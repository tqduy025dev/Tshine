package com.tshine.server.apiserver.service;

import com.tshine.common.entities.system.SystemFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AmazonClientService {
    String uploadFileToS3(MultipartFile multipartFile) throws IOException;
    List<SystemFile> uploadFileToS3(MultipartFile[] multipartFiles) throws IOException;
}
