package com.z4knight.bugmanagement.service;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TDesired;

public interface TDesiredService {
	
	ArrayList<TDesired> selectByTaskId(String id);
	
	
	int  intsertTDesired(TDesired ted);
	
	Integer  updateRedact(TDesired ted);
	
	int    delectRedact(String demed);
	
	ArrayList<TDesired> renewal(String taskid);
	
	ArrayList<TDesired> renewalFilter(TDesired demded);
}
