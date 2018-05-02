package com.z4knight.bugmanagement.dataobject;

public class TAssigntest{
	
	    private Integer id;

	    private String assignusernumber;
	    
	    private String assignusername;

	    private String assignuserpart;


	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getAssignusernumber() {
	        return assignusernumber;
	    }

	    public void setAssignusernumber(String assignusernumber) {
	        this.assignusernumber = assignusernumber == null ? null : assignusernumber.trim();
	    }
  
    private String assignuserorganization;

    public String getAssignusername() {
        return assignusername;
    }

    public void setAssignusername(String assignusername) {
        this.assignusername = assignusername == null ? null : assignusername.trim();
    }

    public String getAssignuserpart() {
        return assignuserpart;
    }

    public void setAssignuserpart(String assignuserpart) {
        this.assignuserpart = assignuserpart == null ? null : assignuserpart.trim();
    }

    public String getAssignuserorganization() {
        return assignuserorganization;
    }

    public void setAssignuserorganization(String assignuserorganization) {
        this.assignuserorganization = assignuserorganization == null ? null : assignuserorganization.trim();
    }
}