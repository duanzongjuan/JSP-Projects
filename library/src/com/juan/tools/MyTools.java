package com.juan.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTools {
	static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
	static final DateFormat DFALL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date stringToDate(String str) throws ParseException{
		Date date = null;
		date = DF.parse(str);
		return date;
	}
	
	public static String dateToString(Date date) {
		String str = null;
		str = DF.format(date);
		return str;
	}
	
	public static Date allStringToDate(String str) throws ParseException {
		Date date = null;
		date = DFALL.parse(str);
		return date;
	}
	
	public static String allDateToString(Date date) {
		String str = null;
		str = DFALL.format(date);
		return str;
	}
	
	public static boolean isNumber(String num) {
		int n;
		if(num != null || !"".equals(num)) {
			n = Integer.parseInt(num);
			return true;
		} else {
			return false;
		}
	}
}
