package com.z4knight.bugmanagement.service;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TAssigntest;
import com.z4knight.bugmanagement.dataobject.TCasetest;
import com.z4knight.bugmanagement.dataobject.TCasetestgather;

public interface TCaseTestService {
	
	
	ArrayList<TCasetest> activityList(String caseber);
	
	int insertINto(TCasetest Tcaetest);
	
	int insertIntoPeople(TCasetest Tcaetest);
	/**
	 * 人员列表
	 * @return
	 */
	ArrayList<TAssigntest> assigntestList();
	
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
