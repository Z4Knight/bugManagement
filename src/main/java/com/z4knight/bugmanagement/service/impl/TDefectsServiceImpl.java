package com.z4knight.bugmanagement.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.Resource;

import com.z4knight.bugmanagement.dataobject.TDefects;
import com.z4knight.bugmanagement.repository.TDefectsMapper;
import com.z4knight.bugmanagement.service.TDefectsService;
import org.springframework.stereotype.Service;



import cn.lz.cloud.common.util.UUID;
@Service
public class TDefectsServiceImpl implements TDefectsService {
	 @Resource
	 private TDefectsMapper tdfecm;
	 Date day=new Date(); 
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public ArrayList<TDefects> findList() {
		
		return tdfecm.findList();
	}
	@Override
	public int insertInto(TDefects tdefec) {
		tdefec.setDefectsnumber(UUID.getUUID());
		tdefec.setDefectscreator("byw");
		tdefec.setDefectscreattime(df.format(day));
		return tdfecm.insertInto(tdefec);
	}
	@Override
	public TDefects updateSelect(TDefects tdefec) {
	
		return tdfecm.updateSelect(tdefec);
	}
	@Override
	public int updateTdefec(TDefects tdefec) {
		System.out.println(df.format(day));
		tdefec.setDefectscreattime(df.format(day));
		return tdfecm.updateTdefec(tdefec);
	}
	@Override
	public int delectTdefec(TDefects tdefec) {
		
		return tdfecm.delectTdfec(tdefec);
	}
}
