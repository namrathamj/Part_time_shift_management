package com.umass.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class DateTimeUtil {

	// Helper method to parse date strings
	public static Date parseDateString(String dateString, Optional<String> format) {
		String formatToParseFrom = format.orElse("yyyy-MM-dd'T'HH:mm:ss.SSS");

		SimpleDateFormat dateFormat = new SimpleDateFormat(formatToParseFrom);
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
