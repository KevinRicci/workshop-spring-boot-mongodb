package com.kevinrh.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	public static String decodeParam(String text) {
		try {
			String txt = URLDecoder.decode(text, "UTF-8");
			return txt;
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
