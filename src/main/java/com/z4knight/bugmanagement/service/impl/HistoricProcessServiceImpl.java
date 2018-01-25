package com.z4knight.bugmanagement.service.impl;

import cn.lz.cloud.common.util.UUID;
import com.z4knight.bugmanagement.dataobject.HistoricProcess;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.util.DateUtil;
import com.z4knight.bugmanagement.repository.HistoricProcessMapper;
import com.z4knight.bugmanagement.service.HistoricProcessService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @Author Z4knight
 * @Date 2018/1/22 11:26
 *
 * 流转记录服务实现类
 */

@Service
public class HistoricProcessServiceImpl implements HistoricProcessService{

    @Autowired
    private HistoricProcessMapper mapper;

    @Override
    public List<HistoricProcess> selectAll() {
        return null;
    }

    @Override
    public List<HistoricProcess> selectByProcAssigner(String procAssigner) {
        return null;
    }


    @Override
    public HistoricProcess update(HistoricProcess process) {
        mapper.update(process);
        return process;
    }

    @Override
    public List<HistoricProcess> selectByObjectId(String objectId) {
        if (StringUtils.isEmpty(objectId)) {
            throw new ServiceException(ErrorMsg.BUSINESS_CODE_NOT_EXIST.getMsg());
        }
        List<HistoricProcess> list =  mapper.selectByObjectId(objectId);
        if (null == list || list.size() == 0) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        return list;
    }

    @Override
    public HistoricProcess save(HistoricProcess process) {
        HistoricProcess result = new HistoricProcess();
        BeanUtils.copyProperties(process, result);
        result.setUuid(UUID.getUUID());
        result.setCreateTime(DateUtil.getCurrentTime());
        mapper.save(result);
        return result;
    }

    @Override
    public HistoricProcess delete(String objectId) {
        return null;
    }
}
