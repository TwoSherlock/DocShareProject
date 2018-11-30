package com.sm.common;

public class DocShareMsgException extends Exception{
    private String msg;
    private int stCode;

    public DocShareMsgException(){

    }

    public DocShareMsgException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}
