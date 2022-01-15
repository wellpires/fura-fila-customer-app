package br.com.furafilapp.customerapp.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.furafilapp.customerapp.validator.GenderValidator;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = GenderValidator.class)
public @interface Gender {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
