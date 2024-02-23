package com.tshine.common.utils;

import com.tshine.common.factory.KeyGenarator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    public static File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }

    public static String generateFileName(String fileName) {
        return KeyGenarator.getKey() + fileName.replaceAll("\\s+", "_");
    }
    public static File createFile(String fileName, String... pathFolder) throws IOException {
        File folderPath = FileUtils.createFolder(pathFolder);
        logger.info("******FileUtils folderPath=" + folderPath.getAbsolutePath());
        File file = new File(folderPath.getPath() + "/" + generateFileName(fileName));
        logger.info("******FileUtils filePath=" + file.getAbsolutePath());
        if(file.createNewFile()){
            return file;
        }
        throw new IOException("FileUtils: createFile() ERROR Invalid file path");
    }
    private static File createFolder(@NonNull String... rootFolder) {
        StringBuilder path = new StringBuilder();
        for (String fd : rootFolder){
            if(StringUtils.isNotEmpty(fd)){
                path.append("/").append(fd);
            }
        }
        File folderPath = new File(path.toString());
        if (!folderPath.isDirectory()) {
            boolean isCreated = folderPath.mkdirs();
            if(isCreated){
                FileUtils.chmod(folderPath, "777");
            }
        }
        return folderPath;
    }

    private static void chmod(File file, String mode) {
        String os = System.getProperty("os.name");
        if (os.contains("Windows") || os.contains("windows")) {
            return;
        }
        String cmd = "chmod " + mode + " " + file.getAbsolutePath();
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd);
            int waitFor = proc.waitFor();
            logger.info("===========FileUtils chmod() waitFor= " + waitFor);
        } catch (Exception e) {
            logger.error("===========FileUtils chmod() ERROR===========", e);
        }
    }
}
