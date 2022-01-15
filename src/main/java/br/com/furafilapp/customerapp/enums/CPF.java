package br.com.furafilapp.customerapp.enums;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.furafilapp.customerapp.validator.CpfValidator;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = CpfValidator.class)
public @interface CPF {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
