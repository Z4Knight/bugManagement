package com.z4knight.bugmanagement.repository;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.Testexecution;


public interface TestexecutionMapper {
/**
 * 测试用例表（测试执行管理）	
 * @param
 * @return
 */
ArrayList<Testexecution> selectlist(Testexecution testcu);

/**
 * 执行用例
 * @param
 * @return
 */
Testexecution executeTest(Testexecution testcu);
/**
 * 新增缺陷
 * @param
 * @return
 */
int insertInto(Testexecution tdefec);
/**
 * 更新测试用例表
 * @param
 * @return
 */
ArrayList<Testexecution> selectlist2(Testexecution testcu);
}
