package com.sm.util;

import com.sm.docShare.DocShareHelper;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     * 获得盐值加密后的密码
     * @param pwd
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String md5SoltGenerator(String pwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(md5.digest(pwd.getBytes("utf-8")))+ DocShareHelper.solt;
        String md5Pwd = encoder.encode(md5.digest(encode.getBytes("utf-8")));
        return md5Pwd;
    }
}
