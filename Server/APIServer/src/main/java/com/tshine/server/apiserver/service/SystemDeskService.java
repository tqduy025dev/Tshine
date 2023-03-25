package com.tshine.server.apiserver.service;

import com.tshine.common.dto.base.BaseData;
import com.tshine.common.dto.system.DeskRequest;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface SystemDeskService {
    BaseData createDesk(DeskRequest deskRequest);
    BaseData findDeskById(String id);
    BaseData findDeskByFields(Map<String, String> map, Pageable pageable);
}
