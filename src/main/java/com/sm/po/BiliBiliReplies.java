package com.sm.po;

public class BiliBiliReplies {

    private String mid;//会员id
    private String uname;//会员昵称
    private String avId;
    private int pageSize;
    private String[] excludeUsrs;

    public String[] getExcludeUsrs() {
        return excludeUsrs;
    }

    public void setExcludeUsrs(String[] excludeUsrs) {
        this.excludeUsrs = excludeUsrs;
    }

    public String getAvId() {
        return avId;
    }

    public void setAvId(String avId) {
        this.avId = avId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
