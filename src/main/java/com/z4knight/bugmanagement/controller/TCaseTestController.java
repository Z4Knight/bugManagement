package com.z4knight.bugmanagement.controller;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TAssigntest;
import com.z4knight.bugmanagement.dataobject.TCasetest;
import com.z4knight.bugmanagement.dataobject.TCasetestgather;
import com.z4knight.bugmanagement.service.TCaseTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ActivityCollect")
public class TCaseTestController {
	 @Autowired
	 private TCaseTestService tcTS;
	 
	 @RequestMapping("/list")
	 
	 public ArrayList<TCasetest> activityList(@RequestBody String casetestnumber)
	 {
		 
		 return tcTS.activityList(casetestnumber);
	 }
	 @RequestMapping("/choice")
	 public int insertINto(@RequestBody TCasetest Tcaetest)
	 {
		 return tcTS.insertINto(Tcaetest);
	 }
	 @RequestMapping("/distribution")
	 public int insertIntoPeople(@RequestBody TCasetest Tcaetest)
	 {
		 return tcTS.insertIntoPeople(Tcaetest);
	 }
	 @RequestMapping("/human")
	 public ArrayList<TAssigntest> assigntestList()
	 {  
		 return tcTS.assigntestList();
	 }
	 @RequestMapping("/delect")
	 public int delectTcaseTest(@RequestBody TCasetestgather Tcaetest)
	 {  
		 return tcTS.delectTcaseTest(Tcaetest);
	 }
	 @RequestMapping("/update")
	 public ArrayList<TCasetestgather> updateTest(@RequestBody TCasetestgather Tcaetest)
	 {  
		 System.out.println(Tcaetest.getCasetestnumber());
		 return tcTS.updateTest(Tcaetest);
		
	 }
	 @RequestMapping("/filtrate")
	 public ArrayList<TCasetestgather> findFiltrate(@RequestBody TCasetestgather Tcaetest)
	 {  
		 return tcTS.findFiltrate(Tcaetest);
		
	 }
}