package com.TestDemo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String encodeValue(String str){
		StringBuilder sb=new StringBuilder();
		try {
			//创建 MessageDigest
			MessageDigest md=MessageDigest.getInstance("md5");//MD5 
			//加密 
			byte[] digest = md.digest(str.getBytes());
			
			//将加密结果 --> sb 
			//byte -- > 2 char     强转
			// byte -> -128  ~ 127 -> 0~255 范围 
			for (int i = 0; i < digest.length; i++) {
				byte b = digest[i];
				
				int intValue=b&0xff;  // 0`255 范围
				//10进制  -- 16进制
				//案例  0 0  
				//   1  1
				//   9  9
				//   10 A
				//   11 B
				// ...
				//   15 F
				//   16 10
				//   20 14
				//  ...
				//   255 FF
				if(intValue<16){
					sb.append(0);
				}
				sb.append(Integer.toHexString(intValue));
				
			}
			
			
						
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		String encodeValue = MD5Util.encodeValue("123456");
		System.out.println(encodeValue);
	}
}
