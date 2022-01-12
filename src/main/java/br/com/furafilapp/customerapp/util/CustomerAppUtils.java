package br.com.furafilapp.customerapp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

public class CustomerAppUtils {

	public static LocalDate stringToLocalDate(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		return LocalDate.parse(value, DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
	}

}
