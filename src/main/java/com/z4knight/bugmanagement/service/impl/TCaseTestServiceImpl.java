package com.z4knight.bugmanagement.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.z4knight.bugmanagement.dataobject.TAssigntest;
import com.z4knight.bugmanagement.dataobject.TCase;
import com.z4knight.bugmanagement.dataobject.TCasetest;
import com.z4knight.bugmanagement.dataobject.TCasetestgather;
import com.z4knight.bugmanagement.repository.TAssigntestMapper;
import com.z4knight.bugmanagement.repository.TCaseMapper;
import com.z4knight.bugmanagement.repository.TCaseTestMapper;
import com.z4knight.bugmanagement.service.TCaseTestService;
import com.z4knight.bugmanagement.util.ArrayDeduplication;
import org.springframework.stereotype.Service;

@Service
public class TCaseTestServiceImpl implements TCaseTestService {
	 @Resource
	 private TCaseTestMapper tcTSmaper;
	 @Resource
	 private TAssigntestMapper tastesmaper;
	 @Resource
	 private TCaseMapper tcmaper;
	 Date day=new Date(); 
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     //数组去重
	 private ArrayDeduplication arraydeduplication;
	@Override
	public ArrayList<TCasetest> activityList(String caseber) {

		ArrayList<TCasetest> activityList = tcTSmaper.activityList(caseber);
		return activityList;
		
	}
	@Override
	public int insertINto(TCasetest Tcaetest) {
		//申明两个动态数组
		String[] a = new String [30];
		String[] b = new String [30];
		if(Tcaetest.getCasetestnumber().equals(null) ||"".equals(Tcaetest.getCasetestnumber()))
		{
			return 0;
		}
		if(Tcaetest.getCottomnumber2().size()==0)
		{
			return 0;
		}
		//拿到数组数据，并遍历。(Cottomnumber)
		List<String> list = Tcaetest.getCottomnumber2();
		int len = list.size();
		for (int i = 0 ; len>i ; i++) {
			 a [i] = list.get(i);
		}
//		System.out.println(a[0]+a[1]);
		//拿到数据(Casetestnumber)
		String string2 = Tcaetest.getCasetestnumber();
		//查找相关集合的所有测试案例
		ArrayList<TCasetest> activityList = tcTSmaper.activityList(string2);
		int size = activityList.size();
		for(int j = 0 ;size > j ; j++)
		{
			b[j] = activityList.get(j).getCottomnumber();
		}
//	   System.out.println(b[0]+"......"+b[1]);
       //数组去重 
	   String[] arrResult = arraydeduplication.arrContrast(a, b);
	   for (String strResult : arrResult)
	   {  
		   ArrayList<TCase> tCaseList = tcmaper.TCaseList(strResult);
		   for (TCase tCase : tCaseList)
		   {
			   Tcaetest.setCasetestnumber(string2);
				Tcaetest.setCottomnumber(strResult);
				Tcaetest.setCottomname(tCase.getCottomname());
				Tcaetest.setCottommodule(tCase.getCottommodule());
				Tcaetest.setCottomdescribe(tCase.getCottomdescribe());
				Tcaetest.setCottompriority(tCase.getCottompriority());
				Tcaetest.setCottompreposition(tCase.getCottompreposition());
				Tcaetest.setCottomoperating(tCase.getCottomoperating());
				Tcaetest.setCottomexpect(tCase.getCottomexpect());
				Tcaetest.setCottomtype(tCase.getCottomtype());
				Tcaetest.setCottomexample(tCase.getCottomexample());
				Tcaetest.setCottomwriter(tCase.getCottomwriter());
				Tcaetest.setCottompurpose("宁夏");
//				Tcaetest.setCottomoperator("上海");
				Tcaetest.setCottomstate("北京");
				Tcaetest.setCottomtest(tCase.getCottomtest());
				Tcaetest.setCottomsmoking(tCase.getCottomsmoking());
				Tcaetest.setCottomcopy(tCase.getCottomcopy());
				Tcaetest.setCottomregression(tCase.getCottomregression());
				Tcaetest.setCottomremark(tCase.getCottomremark());
			    tcTSmaper.insertINto(Tcaetest);
		   }
       }  
		return 1;
	}
	@Override
	public int insertIntoPeople(TCasetest Tcaetest) {
	//	ArrayList<TAssigntest> assigntestList = tastesmaper.assigntestList();
		
		tcTSmaper.insertIntoPeople(Tcaetest);
		return 1;
	}
	@Override
	public ArrayList<TAssigntest> assigntestList() {
		ArrayList<TAssigntest> assigntestList = tastesmaper.assigntestList();
		return assigntestList;
	}
	@Override
	public int delectTcaseTest(TCasetestgather Tcaetest) {
		tcTSmaper.delectTcaseTest(Tcaetest);
		return 1;
	}
	@Override
	public ArrayList<TCasetestgather> updateTest(TCasetestgather Tcaetest) {
		ArrayList<TCasetestgather> list = tcTSmaper.updateTest(Tcaetest);
		return list;
	}
	@Override
	public ArrayList<TCasetestgather> findFiltrate(TCasetestgather Tcaetest) {
		ArrayList<TCasetestgather> list = tcTSmaper.findFiltrate(Tcaetest);
		return list;
	}
}

