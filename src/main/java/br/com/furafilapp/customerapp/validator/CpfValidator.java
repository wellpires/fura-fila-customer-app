package br.com.furafilapp.customerapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.furafilapp.customerapp.enums.CPF;
import br.com.furafilapp.customerapp.util.CustomerAppUtils;

public class CpfValidator implements ConstraintValidator<CPF, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return CustomerAppUtils.isCPF(value);
	}

}
