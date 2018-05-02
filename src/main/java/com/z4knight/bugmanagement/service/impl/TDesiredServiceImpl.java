package com.z4knight.bugmanagement.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.z4knight.bugmanagement.dataobject.TDesired;
import com.z4knight.bugmanagement.repository.TDesiredMapper;
import com.z4knight.bugmanagement.service.TDesiredService;
import org.springframework.stereotype.Service;



import cn.lz.cloud.common.util.UUID;

@Service
public class TDesiredServiceImpl implements TDesiredService {
   @Resource
  private TDesiredMapper tdeMapper;
  Date day=new Date();    
	@Override
	public ArrayList<TDesired> selectByTaskId(String id) {
		
		return tdeMapper.selectByTaskId(id);
	}
	@Override
	public int intsertTDesired(TDesired ted) {
		ArrayList<TDesired> selectAllTDesired = tdeMapper.selectAllTDesired();
		List<String>  str = new ArrayList<String>();
		// 生成uuid
		ted.setDemencoded(UUID.getUUID());
		ted.setDemwriter("白耀武");
		//拿到系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		ted.setDemwtime(df.format(day));
		//  ||：短路或(有一个为ture结果为ture)
		if("".equals(ted.getTaskid()) || ted.getTaskid().equals(null))
		{
			return 0;
		}
		for (TDesired tDesired : selectAllTDesired) {
			 String string = tDesired.getDemencoded();
			 str.add(string);
		}
		for (String string2 : str) {
			//字符串判断equals
				if(ted.getDemencoded().equals(string2))
				{
					return 0;
				}
			}
		tdeMapper.intsertTDesired(ted);
		return 1;
		}
	@Override
	public Integer updateRedact(TDesired ted) {
		ted.setDemmodifier("颜吉军");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		ted.setDemmtime(df.format(day));
		Integer redact = tdeMapper.updateRedact(ted);
		return redact;
	}
	@Override
	public int delectRedact(String demed) {
		int redact = tdeMapper.delectRedact(demed);
		return redact;
	}
	@Override
	public ArrayList<TDesired> renewal(String taskid) {
		ArrayList<TDesired> list = tdeMapper.renewal(taskid);
		return list;
	}
	@Override
	public ArrayList<TDesired> renewalFilter(TDesired demded) {
		return tdeMapper.renewalFilter(demded);
	}
}
