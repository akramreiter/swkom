package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.Recipient;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CityValidator implements ConstraintValidator<City, Recipient> {

    private static final Pattern CITY_PATTERN = Pattern.compile("^[A-Z][ a-zA-Z-/]*");

    @Override
    public void initialize(City constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

    }

    @Override
    public boolean isValid(Recipient recipient, ConstraintValidatorContext constraintValidatorContext) {
        if("Österreich".equals(recipient.getCountry()) || "Austria".equals(recipient.getCountry())) {
            return CITY_PATTERN.matcher(recipient.getCity()).matches();
        } else {
            return true;
        }
    }
}