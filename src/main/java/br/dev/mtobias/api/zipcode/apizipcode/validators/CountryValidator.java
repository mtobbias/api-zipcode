package br.dev.mtobias.api.zipcode.apizipcode.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CountryValidatorValidator.class)
public @interface CountryValidator {
    public String message() default "";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
