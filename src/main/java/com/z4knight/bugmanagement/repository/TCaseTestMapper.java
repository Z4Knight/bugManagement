package com.z4knight.bugmanagement.repository;
import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TCasetest;
import com.z4knight.bugmanagement.dataobject.TCasetestgather;

public interface TCaseTestMapper {
	/**
	 * 测试集列表(对选择的案例进行判断（是否重复）)
	 * @param caseber
	 * @return
	 */
	ArrayList<TCasetest> activityList(String caseber);
	
	/**
	 * 选择案例添加到测试集（选择用例）
	 * @param Tcaetest
	 * @return
	 */
	int insertINto(TCasetest Tcaetest);
	/**
	 * 分配执行人
	 * @param Tcaetest
	 * @return
	 */
	int insertIntoPeople(TCasetest Tcaetest);
	/**
	 * 删除测试用例（根据测试集编号删除具体测试用例）
	 * @param
	 * @param
	 * @return
	 */
	int  delectTcaseTest(TCasetestgather Tcaetest);
	/**
	 * 更新测试集列表
	 * @param Tcaetest
	 * @return
	 */
	ArrayList<TCasetestgather> updateTest(TCasetestgather Tcaetest);
	/**
	 * 筛选条件
	 * @param Tcaetest
	 * @return
	 */
	ArrayList<TCasetestgather> findFiltrate(TCasetestgather Tcaetest);
	
	
}
