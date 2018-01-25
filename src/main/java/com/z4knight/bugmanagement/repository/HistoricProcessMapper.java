package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.HistoricProcess;


import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/22 10:46
 *
 * 流转记录-mapper类
 */
public interface HistoricProcessMapper {

    List<HistoricProcess> selectAll();

    List<HistoricProcess> selectByProcAssigner(String procAssigner);

    void update(HistoricProcess process);

    List<HistoricProcess> selectByObjectId(String objectId);

    void save(HistoricProcess process);

    void delete(String objectId);
}
