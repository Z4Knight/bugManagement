package com.z4knight.bugmanagement.controller;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TCase;
import com.z4knight.bugmanagement.service.TCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/ClassicCollect")
public class TCaseController {
    @Autowired
    private TCaseService TCSer;
    @RequestMapping("/list")
    public ArrayList<TCase> selectList(@RequestBody String demencoded)
    {
    	return TCSer.selectList(demencoded);
    }
   @RequestMapping("/insert")
   public int insert(@RequestBody TCase tc)
   {
	   
	   return TCSer.insertCase(tc);
   }
   @RequestMapping("/alter")
   public int update(@RequestBody TCase tc)
   {
	   return TCSer.update(tc);
   }
   @RequestMapping("/delect")
   public int delect(@RequestBody TCase tc)
   {
	   return TCSer.delect(tc);
   }
   @RequestMapping("/update")
   public ArrayList<TCase> updateList(@RequestBody String demend)
   {
	   return TCSer.updateList(demend);
   }
   @RequestMapping("/screen")
    public ArrayList<TCase> screenList(@RequestBody TCase tc)
   {
	   return TCSer.screenList(tc);
   }
   @RequestMapping("/TCaseList")
   public ArrayList<TCase> TCaseList(@RequestBody TCase tcase)
  {
	 return TCSer.TCaseList(tcase);
  }
}
