package br.com.furafilapp.customerapp.enums;

import java.util.Arrays;

public enum Gender {

	M, F;

	public static Gender parseOf(String gender) {
		return Arrays.asList(values()).stream().filter(item -> {
			return item.name().equalsIgnoreCase(gender);
		}).findFirst().orElseGet(() -> null);
	}

}
