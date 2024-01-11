package com.tshine.service.service.impl;

import com.tshine.common.entities.system.SystemFile;
import com.tshine.service.service.SystemFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemFileServiceImpl implements SystemFileService {
    @Override
    public String saveFileToStorage(MultipartFile file, String dir) throws IOException {
        Path filepath = Paths.get(dir, file.getOriginalFilename());
        file.transferTo(filepath);
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
