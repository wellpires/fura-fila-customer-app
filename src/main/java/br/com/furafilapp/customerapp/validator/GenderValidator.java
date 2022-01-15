package br.com.furafilapp.customerapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.furafilapp.customerapp.annotation.Gender;

public class GenderValidator implements ConstraintValidator<Gender, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return "M".equalsIgnoreCase(value) || "F".equalsIgnoreCase(value);
	}

}
