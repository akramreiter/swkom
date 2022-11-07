package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.Recipient;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PostalCodeValidator implements ConstraintValidator<PostalCode, Recipient> {

    private static final Pattern POSTALCODE_PATTERN = Pattern.compile("^A-[0-9][0-9][0-9][0-9]");
    @Override
    public void initialize(PostalCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Recipient recipient, ConstraintValidatorContext constraintValidatorContext) {
        if("Österreich".equals(recipient.getCountry()) || "Austria".equals(recipient.getCountry())) {
            return POSTALCODE_PATTERN.matcher(recipient.getPostalCode()).matches();
        } else {
            return true;
        }
    }
}