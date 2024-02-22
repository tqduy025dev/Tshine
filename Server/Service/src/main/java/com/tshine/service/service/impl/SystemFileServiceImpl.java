package com.tshine.service.service.impl;

import com.tshine.common.entities.system.SystemFile;
import com.tshine.common.utils.FileUtils;
import com.tshine.service.service.SystemFileService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemFileServiceImpl implements SystemFileService {
    private final ApplicationContext context;

    public SystemFileServiceImpl(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public String saveFileToStorage(MultipartFile file, String dir) throws IOException {
        File filepath = FileUtils.createFile(file.getOriginalFilename(), dir, "test");
        FileCopyUtils.copy(file.getInputStream(), Files.newOutputStream(filepath.toPath()));
        return filepath.toString();
    }

    @Override
    public List<SystemFile> saveFileToStorage(MultipartFile[] files, String dir) throws IOException {
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
