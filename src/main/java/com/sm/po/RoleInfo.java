package com.sm.po;

import java.util.Date;

public class RoleInfo {
    private Integer roleId;

    private String roleNm;

    private String st;

    private String crtr;

    private Date crtm;

    private String updtr;

    private Date updtm;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleNm() {
        return roleNm;
    }

    public void setRoleNm(String roleNm) {
        this.roleNm = roleNm == null ? null : roleNm.trim();
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