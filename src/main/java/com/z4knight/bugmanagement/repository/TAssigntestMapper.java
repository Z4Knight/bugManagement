package com.z4knight.bugmanagement.repository;



import com.z4knight.bugmanagement.dataobject.TAssigntest;

import java.util.ArrayList;

public interface TAssigntestMapper {
	/**
	 * 人员列表
	 * @return
	 */
	ArrayList<TAssigntest> assigntestList();
	/**
	 * 选中具体人员
	 * @param assignusernumber
	 * @return
	 */
	TAssigntest  assignuser(String assignusernumber);
}