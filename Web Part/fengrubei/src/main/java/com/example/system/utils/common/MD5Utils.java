package com.example.system.utils.common;


import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Utils {

	/**
	 * 
	 * @Title: MD5Utils.java
	 * @Package com.imooc.utils
	 * @Description: 对字符串进行md5加密
	 */
	public static String getMD5Str(String strValue) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		//String newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));

		return new BigInteger(1, md5.digest(strValue.getBytes())).toString(16);
	}

	public static void main(String[] args) {
		try {
			String md5 = getMD5Str("123456");
			md5 = getMD5Str(md5);
			System.out.println(md5);
			System.out.println("14e1b600b1fd579f47433b88e8d85291");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
