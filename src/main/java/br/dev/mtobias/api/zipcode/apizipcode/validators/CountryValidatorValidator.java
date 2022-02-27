package br.dev.mtobias.api.zipcode.apizipcode.validators;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class CountryValidatorValidator implements ConstraintValidator<CountryValidator, String> {
    private static final List<String> VALID_COUNTRIES = Arrays.asList("br","pt");

    @Override
    public void initialize(CountryValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return VALID_COUNTRIES.contains(s);
    }
}
