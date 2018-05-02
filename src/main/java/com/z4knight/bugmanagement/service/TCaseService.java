package com.z4knight.bugmanagement.service;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TCase;

public interface TCaseService {

	ArrayList<TCase> selectList(String demencoded);
	
	int insertCase(TCase demencoded);
	
	int  update(TCase tcase); 
	
	int delect(TCase tcase);
	
	ArrayList<TCase> updateList(String demded);
	
	ArrayList<TCase>  screenList(TCase tcase);
	
	ArrayList<TCase> TCaseList(TCase tcase);
}
