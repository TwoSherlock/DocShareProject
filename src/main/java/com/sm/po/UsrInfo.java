package com.sm.po;

import java.util.Date;

public class UsrInfo {
    private Integer usrId;

    private String usrNm;

    private String usrPwd;

    private String st;

    private String crtr;

    private Date crtm;

    private String updtr;

    private Date updtm;

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrNm() {
        return usrNm;
    }

    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm == null ? null : usrNm.trim();
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd == null ? null : usrPwd.trim();
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st == null ? null : st.trim();
    }

    public String getCrtr() {
        return crtr;
    }

    public void setCrtr(String crtr) {
        this.crtr = crtr == null ? null : crtr.trim();
    }

    public Date getCrtm() {
        return crtm;
    }

    public void setCrtm(Date crtm) {
        this.crtm = crtm;
    }

    public String getUpdtr() {
        return updtr;
    }

    public void setUpdtr(String updtr) {
        this.updtr = updtr == null ? null : updtr.trim();
    }

    public Date getUpdtm() {
        return updtm;
    }

    public void setUpdtm(Date updtm) {
        this.updtm = updtm;
    }
}