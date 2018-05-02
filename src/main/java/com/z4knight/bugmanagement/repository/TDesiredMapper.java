package com.z4knight.bugmanagement.repository;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TDesired;

public interface TDesiredMapper {
   /**
    * 测试需求列表
    * @param id
    * @return
    */
   ArrayList<TDesired> selectByTaskId(String id);
   
   /**
    * 新增测试需求
    */
   int  intsertTDesired(TDesired ted);
   /**
    * 新增之前进行判断
    * @return
    */
   ArrayList<TDesired> selectAllTDesired();
   
   
  /**
   * 编辑测试需求
   * @param
   * @return
   */
   Integer  updateRedact(TDesired demded);
   /**
    * 删除测试需求
    * @param
    * @return
    */
    int   delectRedact(String deded);
    /**
     * 更新测试需求
     * @param taskid
     * @return
     */
    ArrayList<TDesired> renewal(String taskid);
    /**
     * 筛选条件
     * @param demded
     * @return
     */
    ArrayList<TDesired> renewalFilter(TDesired demded);
}