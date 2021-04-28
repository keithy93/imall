package com.imooc.imall.util;

import com.imooc.imall.common.Constant;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest((strValue + Constant.salt).getBytes()));
    }

    public static void main(String[] args) {
        try {
            String md5 = MD5Utils.getMD5Str("12345");
            System.out.println(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}