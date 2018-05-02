package com.z4knight.bugmanagement.service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.z4knight.bugmanagement.repository.TCaseMapper;
import com.z4knight.bugmanagement.service.TCaseService;
import org.springframework.stereotype.Service;

import com.z4knight.bugmanagement.dataobject.TCase;



import cn.lz.cloud.common.util.UUID;
@Service
public class TCaseServiceImpl implements TCaseService {
	 @Resource
	 private TCaseMapper tcmaper;
	 Date day=new Date(); 
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public ArrayList<TCase> selectList(String demencoded) 
	{
		
		return tcmaper.selectList(demencoded);
	}
	@Override
	public int insertCase(TCase demencoded)
	{
		ArrayList<TCase> selectTwo = tcmaper.selectTwo();
	    List<String>  list = new ArrayList<String>();
		for (TCase tCase : selectTwo) {
			String string = tCase.getDemencoded();
			list.add(string);
		}
		for (String string : list) {
			if (demencoded.getDemencoded().equals(string)) {		
				demencoded.setCottomnumber(UUID.getUUID());
				demencoded.setCottomwriter("byw");
				demencoded.setCottomtime(df.format(day));
				tcmaper.insertCase(demencoded);
				return 1;
			}
		}
		return 0;
	}
	@Override
	public int update(TCase tcase)
	{    
		tcase.setCottommodifier("yjj");
		tcase.setCottommodifiertime(df.format(day));
		return tcmaper.update(tcase);
	}
	@Override
	public int delect(TCase tcase) {
		if(tcase!=null)
		{
			return tcmaper.delect(tcase);
		}
		return 0;
	}
	@Override
	public ArrayList<TCase> updateList(String demded) {
		if(demded.equals(null) ||"".equals(demded) )
		{
			return null;
		}
		return tcmaper.updateList(demded);
	}
	@Override
	public ArrayList<TCase> screenList(TCase tcase) {
		
		return tcmaper.screenList(tcase);
	}
	@Override
	public ArrayList<TCase> TCaseList(TCase tcase) 
	{
		   ArrayList<TCase> biglist = new ArrayList<TCase>();
		   List<String> list = tcase.getCottomnumber2();
		   for (String string : list)
		   {
			   ArrayList<TCase> arrayList = tcmaper.TCaseList(string);
			   for (TCase tCase2 : arrayList)
			   {
				   biglist.add(tCase2);
			   }
		   }
	       return biglist;
	}
}
