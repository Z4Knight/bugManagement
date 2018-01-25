package com.z4knight.bugmanagement.repository;


import com.z4knight.bugmanagement.dataobject.GeneralProcess;
import com.z4knight.bugmanagement.vo.GeneralProcessVO;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/11 15:14
 * 
 * 通用流转信息-mapper接口
 */
public interface GeneralProcessMapper {

    List<GeneralProcess> selectAll();

    List<GeneralProcessVO> selectByProcAssigner(String procAssigner);

    void update(GeneralProcess process);

    GeneralProcess selectByObjectId(String objectId);

    void save(GeneralProcess process);

    void delete(String objectId);
}
