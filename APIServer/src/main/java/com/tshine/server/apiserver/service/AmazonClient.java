package com.tshine.server.apiserver.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AmazonClient {
    String uploadFileToS3(MultipartFile multipartFile) throws IOException;
}
