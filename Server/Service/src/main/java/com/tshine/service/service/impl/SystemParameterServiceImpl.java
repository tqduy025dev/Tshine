package com.tshine.service.service.impl;

import com.tshine.common.constants.AppConstants;
import com.tshine.service.service.SystemParameterService;
import org.springframework.stereotype.Service;

@Service
public class SystemParameterServiceImpl implements SystemParameterService {

    @Override
    public String findMaxRequestSize() {
        return AppConstants.DEFAULT_REQUEST_SIZE;
    }
}
