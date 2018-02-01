package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.dataobject.HistoricProcess;
import com.z4knight.bugmanagement.vo.HistoricProcessVO;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/22 10:59
 *
 * 流程记录服务接口
 */
public interface HistoricProcessService {

    List<HistoricProcess> selectAll();

    List<HistoricProcess> selectByProcAssigner(String procAssigner);

    HistoricProcess update(HistoricProcess process);

    List<HistoricProcessVO> selectByObjectId(String objectId);

    HistoricProcess save(HistoricProcess process);

    HistoricProcess delete(String objectId);
}
