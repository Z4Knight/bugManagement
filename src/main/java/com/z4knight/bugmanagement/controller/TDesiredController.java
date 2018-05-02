package com.z4knight.bugmanagement.controller;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TDesired;
import com.z4knight.bugmanagement.service.TDesiredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/DemandCollect")
public class TDesiredController {
	@Autowired
	private TDesiredService tde;

	@RequestMapping("/list")
	public ArrayList<TDesired> select(@RequestBody String id) {
		ArrayList<TDesired> selectByTaskId = tde.selectByTaskId(id);
		return selectByTaskId;

	}
	@RequestMapping("/insert")
	public int insert(@RequestBody TDesired tesed) {
		int intsertTDesired = tde.intsertTDesired(tesed);
		return intsertTDesired;
	}
	@RequestMapping("/redact")
	public Integer update(@RequestBody TDesired tesed) {
		Integer redact = tde.updateRedact(tesed);
		return redact;
	}
	
	@RequestMapping("/delect")
	public int delect(@RequestBody String demed) {
		int delectRedact = tde.delectRedact(demed);
		return delectRedact;
	}
	@RequestMapping("/update")
	public ArrayList<TDesired> updateRenewal(@RequestBody String id) {
		 ArrayList<TDesired> arrayList = tde.renewal(id);
		 return arrayList;
	}
	@RequestMapping("/filtrate")
	public ArrayList<TDesired> renewalFilter(@RequestBody TDesired tesed) {
		System.out.println(tesed.getDemname());
		 ArrayList<TDesired> arrayList = tde.renewalFilter(tesed);
		 return arrayList;
	}
}