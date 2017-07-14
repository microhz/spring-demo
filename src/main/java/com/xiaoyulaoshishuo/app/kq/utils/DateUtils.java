package com.xiaoyulaoshishuo.app.kq.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mapc 
 * @date 2017年6月13日
 */
public class DateUtils {
	
	public static SimpleDateFormat fileDatePreffixSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static SimpleDateFormat dayMonthSDF = new SimpleDateFormat("yyyy-MM-dd");
	
	public static SimpleDateFormat pageSearchSDF = new SimpleDateFormat("yyyy/MM/dd");
	
	public static String getFileDateTimeStamps() {
		return fileDatePreffixSDF.format(new Date());
	}
	
	public static Date stringParseToData(String date) throws ParseException {
		return pageSearchSDF.parse(date);
	}
}
