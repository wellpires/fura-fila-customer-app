package br.com.furafilapp.customerapp.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestUtils {

	public static String localDateToString(LocalDate localdate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN);
		return localdate.format(formatter);
	}

	public static String dateToString(Date date) {
		return new SimpleDateFormat(Constants.DATE_PATTERN).format(date);
	}

}
