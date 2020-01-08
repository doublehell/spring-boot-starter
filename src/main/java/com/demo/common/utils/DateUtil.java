package com.demo.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

final public class DateUtil {

	final public static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<>();
	
	private static DateFormat getDateFormat() {
		DateFormat df = threadLocal.get();
		if(df == null) {
			df = new SimpleDateFormat(DATE_FORMAT);
			threadLocal.set(df);
		}
		return df;
	}
	
    public static String formatDate(Date date)  {
        return getDateFormat().format(date);
    }

    public static Date parse(String strDate) throws ParseException  {
        return getDateFormat().parse(strDate);
    }

	public static Date now() {

		return new Date();
	}  
	
	
}
