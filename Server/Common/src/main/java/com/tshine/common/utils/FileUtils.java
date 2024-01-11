package com.tshine.common.utils;

import com.tshine.common.factory.KeyGenarator;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class FileUtils {
    public static File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }


    public static String generateFileName(String fileName) {
        return KeyGenarator.getKey() + fileName.replaceAll(" ", "_");
    }
}
