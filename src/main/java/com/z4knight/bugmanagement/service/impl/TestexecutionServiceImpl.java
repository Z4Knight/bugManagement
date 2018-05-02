package com.z4knight.bugmanagement.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import com.z4knight.bugmanagement.dataobject.Testexecution;
import com.z4knight.bugmanagement.repository.TestexecutionMapper;
import com.z4knight.bugmanagement.service.TestexecutionService;
import org.springframework.stereotype.Service;


@Service
public class TestexecutionServiceImpl implements TestexecutionService {
	@Resource
	private TestexecutionMapper testexecution;
	 Date day=new Date(); 
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public ArrayList<Testexecution> selectlist(Testexecution testcu) {
	
		return testexecution.selectlist(testcu);
	}
	@Override
	public Testexecution executeTest(Testexecution testcu) {
//		testcu.setCasetestnumber(testcu.getCasetestnumber());
//		testcu.setCottomnumber(testcu.getCottomnumber());
//		testcu.setCottomoperator(testcu.getCottomoperator());
		return testexecution.executeTest(testcu);
	}
	@Override
	public int insertInto(Testexecution testcu) {
		
		return testexecution.insertInto(testcu);
	}
	@Override
	public ArrayList<Testexecution> selectlist2(Testexecution testcu) {
		
		return testexecution.selectlist2(testcu);
	}

}
