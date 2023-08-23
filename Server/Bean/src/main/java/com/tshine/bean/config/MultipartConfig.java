package com.tshine.bean.config;


import com.tshine.service.service.SystemParameterService;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MultipartConfig {
    private final SystemParameterService systemParameterService;

    public MultipartConfig(SystemParameterService systemParameterService) {
        this.systemParameterService = systemParameterService;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        String maxSize = systemParameterService.findMaxRequestSize();
        DataSize maxRequestSize = DataSize.parse(maxSize);
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(maxRequestSize);
        factory.setMaxRequestSize(maxRequestSize);
        return factory.createMultipartConfig();
    }




}
