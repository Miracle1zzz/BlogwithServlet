package com.duanle.util;

import java.io.UnsupportedEncodingException;

public class Tools {
	public static int strToint(String str)
	{
		if(str==null||str.equals(""))
			str="0";
		int i=0;
		try {
			i=Integer.parseInt(str);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	public static String toChinese(String str){
		if(str==null)
			str="";
		try {
			str=new String(str.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			str="";
			// TODO: handle exception
			e.printStackTrace();
		}
		return str;
	}
	
}
