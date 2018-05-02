package com.z4knight.bugmanagement.controller;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TDefects;
import com.z4knight.bugmanagement.service.TDefectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/DefectCollect")
public class TDefectsController {
	 @Autowired
	 private TDefectsService tdfec;
	 
	 @RequestMapping("/list")
	 
	 public ArrayList<TDefects> activityList()
	 {
		 
		 return tdfec.findList();
	 }
 @RequestMapping("/insert")
	 
	 public int insertInto(@RequestBody TDefects tdefec)
	 {
		 
		 return tdfec.insertInto(tdefec);
	 }
 @RequestMapping("/redact")
 
 public TDefects updateSelect(@RequestBody TDefects tdefec)
 {
	 
	 return tdfec.updateSelect(tdefec);
 }
 @RequestMapping("/updatedefec")
 
 public int updateTdefec(@RequestBody TDefects tdefec)
 {
	 
	 return tdfec.updateTdefec(tdefec);
 }
@RequestMapping("/delect")
 
 public int delectTdfec(@RequestBody TDefects tdefec)
 {
	 
	 return tdfec.delectTdefec(tdefec);
 }
@RequestMapping("/update")

public ArrayList<TDefects> activityList2()
{
	 
	 return tdfec.findList();
}
}
