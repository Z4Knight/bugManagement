package com.z4knight.bugmanagement.service.impl;

import cn.lz.cloud.common.util.UUID;
import com.z4knight.bugmanagement.dataobject.HistoricProcess;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.LoggerMsg;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.util.DateUtil;
import com.z4knight.bugmanagement.repository.HistoricProcessMapper;
import com.z4knight.bugmanagement.service.HistoricProcessService;
import com.z4knight.bugmanagement.util.Entity2VoConvert;
import com.z4knight.bugmanagement.vo.HistoricProcessVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @Author Z4knight
 * @Date 2018/1/22 11:26
 *
 * 流转记录服务实现类
 */
@Slf4j
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


    @Transactional
    @Override
    public HistoricProcess update(HistoricProcess process) {
        log.info(LoggerMsg.PROCESS_MANAGER_MSG_UPDATE.getMsg() + ", record={}", process);
        mapper.update(process);
        return process;
    }

    @Override
    public List<HistoricProcessVO> selectByObjectId(String objectId) {
        if (StringUtils.isEmpty(objectId)) {
            log.error(LoggerMsg.PROCESS_MANAGER_RECORD_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.BUSINESS_CODE_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.BUSINESS_CODE_NOT_EXIST.getMsg());
        }
        List<HistoricProcess> list =  mapper.selectByObjectId(objectId);
        List<HistoricProcessVO> voList = Entity2VoConvert.convertProcessRecord(list);
        if (null == voList || voList.size() == 0) {
            log.error(LoggerMsg.PROCESS_MANAGER_RECORD_QUERY_LIST.getMsg() + ", ErrorMsg={}", ErrorMsg.DATA_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        log.info(LoggerMsg.PROCESS_MANAGER_RECORD_QUERY_LIST.getMsg() + ", List={}", voList);
        return voList;
    }

    @Transactional
    @Override
    public HistoricProcess save(HistoricProcess process) {
        HistoricProcess result = new HistoricProcess();
        BeanUtils.copyProperties(process, result);
        result.setUuid(UUID.getUUID());
        result.setCreateTime(DateUtil.getCurrentTime());
        mapper.save(result);
        log.info(LoggerMsg.PROCESS_MANAGER_RECORD_ADD.getMsg() + ", record={}", result);
        return result;
    }

    @Override
    public HistoricProcess delete(String objectId) {
        return null;
    }
}
