package com.tshine.service.service.impl;

import com.tshine.common.entities.system.SystemFile;
import com.tshine.common.utils.FileUtils;
import com.tshine.service.service.SystemFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemFileServiceImpl implements SystemFileService {
    private final Logger logger = LoggerFactory.getLogger(SystemFileServiceImpl.class);

    @Override
    public String saveFileToStorage(MultipartFile file, String... dir) throws IOException {
        logger.info("******Begin SystemFileServiceImpl saveFileToStorage()******");
        File filepath = FileUtils.createFile(file.getOriginalFilename(), dir);
        FileCopyUtils.copy(file.getInputStream(), Files.newOutputStream(filepath.toPath()));
        logger.info("******End SystemFileServiceImpl saveFileToStorage()******");
        return filepath.getAbsolutePath();
    }

    @Override
    public List<SystemFile> saveFileToStorage(MultipartFile[] files, String... dir) throws IOException {
        List<SystemFile> systemFiles = new ArrayList<>();
        for (MultipartFile multipartFile : files) {
            String url = this.saveFileToStorage(multipartFile, dir);
            SystemFile systemFile = new SystemFile();
            systemFile.setUrl(url);
            systemFile.setType(multipartFile.getContentType());
            systemFiles.add(systemFile);
        }
        return systemFiles;
    }

}
