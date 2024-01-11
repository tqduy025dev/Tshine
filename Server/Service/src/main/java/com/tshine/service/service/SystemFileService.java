package com.tshine.service.service;

import com.tshine.common.entities.system.SystemFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SystemFileService {

    String saveFileToStorage(MultipartFile file, String dir) throws IOException;
    List<SystemFile> saveFileToStorage(MultipartFile[] files, String dir) throws IOException;
}
