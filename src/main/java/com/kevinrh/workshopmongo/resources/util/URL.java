package com.kevinrh.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	
	public static String decodeParam(String text) {
		try {
			String txt = URLDecoder.decode(text, "UTF-8");
			return txt;
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date converterStringToDate(String date, Date defaultDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return defaultDate;
		}
	}
}
