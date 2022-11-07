package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.Recipient;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class StreetValidator implements ConstraintValidator<Street, Recipient> {

    private static final Pattern STREET_PATTERN = Pattern.compile(".*"); //FIXME

    @Override
    public void initialize(Street constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Recipient recipient, ConstraintValidatorContext constraintValidatorContext) {
        if ("Österreich".equals(recipient.getCountry()) || "Austria".equals(recipient.getCountry())) {
            return STREET_PATTERN.matcher(recipient.getStreet()).matches();
        } else {
            return true;
        }
    }
}