package com.z4knight.bugmanagement.dataobject;

public class TDesired {
    private Integer id;

    private String demencoded;

    private String demname;

    private String demdescribe;

    private String demmodule;

    private String demsection;

    private String demrisklevel;

    private String dempriority;

    private String demsource;

    private String demsystom;

    private String demremarks;

    private String demwriter;

    private String demwtime;

    private String demmodifier;

    private String demmtime;

    private String taskid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemencoded() {
        return demencoded;
    }

    public void setDemencoded(String demencoded) {
        this.demencoded = demencoded == null ? null : demencoded.trim();
    }

    public String getDemname() {
        return demname;
    }

    public void setDemname(String demname) {
        this.demname = demname == null ? null : demname.trim();
    }

    public String getDemdescribe() {
        return demdescribe;
    }

    public void setDemdescribe(String demdescribe) {
        this.demdescribe = demdescribe == null ? null : demdescribe.trim();
    }

    public String getDemmodule() {
        return demmodule;
    }

    public void setDemmodule(String demmodule) {
        this.demmodule = demmodule == null ? null : demmodule.trim();
    }

    public String getDemsection() {
        return demsection;
    }

    public void setDemsection(String demsection) {
        this.demsection = demsection == null ? null : demsection.trim();
    }

    public String getDemrisklevel() {
        return demrisklevel;
    }

    public void setDemrisklevel(String demrisklevel) {
        this.demrisklevel = demrisklevel == null ? null : demrisklevel.trim();
    }

    public String getDempriority() {
        return dempriority;
    }

    public void setDempriority(String dempriority) {
        this.dempriority = dempriority == null ? null : dempriority.trim();
    }

    public String getDemsource() {
        return demsource;
    }

    public void setDemsource(String demsource) {
        this.demsource = demsource == null ? null : demsource.trim();
    }

    public String getDemsystom() {
        return demsystom;
    }

    public void setDemsystom(String demsystom) {
        this.demsystom = demsystom == null ? null : demsystom.trim();
    }

    public String getDemremarks() {
        return demremarks;
    }

    public void setDemremarks(String demremarks) {
        this.demremarks = demremarks == null ? null : demremarks.trim();
    }

    public String getDemwriter() {
        return demwriter;
    }

    public void setDemwriter(String demwriter) {
        this.demwriter = demwriter == null ? null : demwriter.trim();
    }

    public String getDemwtime() {
        return demwtime;
    }

    public void setDemwtime(String demwtime) {
        this.demwtime = demwtime == null ? null : demwtime.trim();
    }

    public String getDemmodifier() {
        return demmodifier;
    }

    public void setDemmodifier(String demmodifier) {
        this.demmodifier = demmodifier == null ? null : demmodifier.trim();
    }

    public String getDemmtime() {
        return demmtime;
    }

    public void setDemmtime(String demmtime) {
        this.demmtime = demmtime == null ? null : demmtime.trim();
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }
}