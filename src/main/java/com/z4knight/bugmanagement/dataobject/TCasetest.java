package com.z4knight.bugmanagement.dataobject;

import java.util.List;

public class TCasetest extends TCasetestgather{
	
	private String casetestnumber;
	private String casetestname;
	private List<String> cottomnumber2;

	
	public List<String> getCottomnumber2() {
		return cottomnumber2;
	}

	public void setCottomnumber2(List<String> cottomnumber2) {
		this.cottomnumber2 = cottomnumber2;
	}

	public String getCasetestnumber() {
		return casetestnumber;
	}

	public void setCasetestnumber(String casetestnumber) {
		this.casetestnumber = casetestnumber == null ? null : casetestnumber.trim();
	}

	public String getCasetestname() {
		return casetestname;
	}

	public void setCasetestname(String casetestname) {
		this.casetestname = casetestname == null ? null : casetestname.trim();
	}
}