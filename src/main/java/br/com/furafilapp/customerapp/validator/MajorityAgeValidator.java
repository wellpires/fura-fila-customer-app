package br.com.furafilapp.customerapp.validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.furafilapp.customerapp.annotation.MajorityAge;

public class MajorityAgeValidator implements ConstraintValidator<MajorityAge, LocalDate> {

	private static final int MAJORITY_AGE = 18;

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		if (Objects.isNull(value)) {
			return false;
		}
		return Period.between(value, LocalDate.now()).getYears() >= MAJORITY_AGE;
	}

}
