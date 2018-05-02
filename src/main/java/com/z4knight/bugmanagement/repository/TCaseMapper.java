package com.z4knight.bugmanagement.repository;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TCase;

public interface TCaseMapper {
   /**
    * 案例列表
    * @param demencoded
    * @return
    */
	ArrayList<TCase> selectList(String demencoded);
	
	/**
	 * 测试集新增之前判断
	 * @param
	 * @return
	 */
	ArrayList<TCase> TCaseList(String cottomnumber);
	/**
	 * 新增案例
	 * @param demencoded
	 * @return
	 */
	int insertCase(TCase demencoded);
	/**
	 * 新增之前进行判断
	 * @return
	 */
	ArrayList<TCase>  selectTwo();
	/**
	 * 修改案例
	 * @param tcase
	 * @return
	 */
	int  update(TCase tcase);  
	/**
	 * 删除案例
	 * @param tcase
	 * @return
	 */
	int delect(TCase tcase);
	/**
	 * 更新案例
	 * @param demded
	 * @return
	 */
	ArrayList<TCase> updateList(String demded);
	/**
	 * 筛选条件
	 * @param tcase
	 * @return
	 */
	ArrayList<TCase>  screenList(TCase tcase);
}