package com.z4knight.bugmanagement.controller;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.Testexecution;
import com.z4knight.bugmanagement.service.TestexecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ExecuteCollect")
public class TestexecutionController {
	 @Autowired
	    private TestexecutionService testextion;
	    @RequestMapping("/list")
	    public ArrayList<Testexecution> selectList(@RequestBody Testexecution testcu)
	    {
	    	return testextion.selectlist(testcu);
	    }
	    @RequestMapping("/start")
	    public Testexecution executeTest(@RequestBody Testexecution testcu)
	    {
	    	return testextion.executeTest(testcu);
	    }
	    @RequestMapping("/NewDefects")
	    public int insertInto(@RequestBody Testexecution testcu)
	    {
	    	return testextion.insertInto(testcu);
	    }
	    @RequestMapping("/updata")
	    public ArrayList<Testexecution> selectList2(@RequestBody Testexecution testcu)
	    {
	    	return testextion.selectlist2(testcu);
	    }
}
