package com.tshine.server.apiserver.service.impl;

import com.tshine.server.apiserver.entities.system.SystemDesk;
import com.tshine.server.apiserver.repository.SystemDeskRepositories;
import com.tshine.server.apiserver.service.SystemDeskService;
import com.tshine.server.common.dto.base.BaseData;
import com.tshine.server.common.dto.system.DeskRequest;
import com.tshine.server.common.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.tshine.server.common.constants.AppConstants.STATUS_NOT_FOUND;

@Service
public class SystemDeskServiceImpl implements SystemDeskService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SystemDeskRepositories deskRepositories;

    public SystemDeskServiceImpl(SystemDeskRepositories deskRepositories) {
        this.deskRepositories = deskRepositories;
    }

    @Override
    public BaseData createDesk(DeskRequest deskRequest) {
        BaseData baseData = new BaseData();
        try {
            SystemDesk systemDesk = (SystemDesk) AppUtils.converToEntities(deskRequest, SystemDesk.class);
            SystemDesk result = deskRepositories.save(systemDesk);
            baseData.setResult(result);
        }catch (Exception e){
            logger.error("============SystemDeskServiceImpl ERROR createDesk()", e);
            baseData.setError(true);
        }
        return baseData;
    }

    @Override
    public BaseData findDeskById(String id) {
        BaseData baseData = new BaseData();
        try {
            boolean exists = deskRepositories.existsById(id);
            if(exists){
                SystemDesk result = deskRepositories.getReferenceById(id);
                baseData.setResult(result);
            }else {
                baseData.setError(true);
                baseData.setStatus(STATUS_NOT_FOUND);
            }
        }catch (Exception e){
            logger.error("============SystemDeskServiceImpl ERROR findDeskById()", e);
            baseData.setError(true);
        }
        return baseData;
    }

    @Override
    public BaseData findDeskByFields(Map<String, String> map, Pageable pageable) {
        return null;
    }
}
