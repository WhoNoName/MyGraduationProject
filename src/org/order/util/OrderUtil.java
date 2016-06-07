package org.order.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class OrderUtil {
	/**
	 * ��������ֵ
	 * @return ����ֵ
	 */
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/**
	 * ����MD5����
	 * "ժҪ�㷨"����
	 * @param str ����
	 * @return ����
	 */
	public static String md5(String str){
		if(str==null || "".equals(str.trim())){
			return null;
		}
		try {
			MessageDigest digest = 
				MessageDigest.getInstance("MD5");
			byte[] input = str.getBytes();
			byte[] output = digest.digest(input);
			//System.out.println(output.length);
			//����Base64�㷨�����ܺ���ֽ�����ת���ַ���
			String ret = 
				Base64.encodeBase64String(output);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args){
//		String s1 = md5("123456");
//		String s2 = md5("123456");
//		System.out.println(s1);
//		System.out.println(s2);
		System.out.println(createId());
		System.out.println(createId());
	}
}

