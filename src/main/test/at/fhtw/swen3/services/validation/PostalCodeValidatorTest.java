package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostalCodeValidatorTest {

    private PostalCodeValidator unitUnderTest = new PostalCodeValidator();

    @Test
    public void otherCountryIsAlwaysTrue() {
        RecipientEntity r = new RecipientEntity();
        r.setCountry("Deutschland");
        boolean result = unitUnderTest.isValid(r, null);
        assertThat(result).isTrue();
    }

    @Test
    public void austriaWithValidPattern() {
        RecipientEntity r = new RecipientEntity();
        r.setCountry("Austria");
        r.setPostalCode("A-1234");
        boolean result = unitUnderTest.isValid(r, null);
        assertThat(result).isTrue();
    }

    @Test
    public void austriaWithInvalidPattern() {
        RecipientEntity r = new RecipientEntity();
        r.setCountry("Austria");
        r.setPostalCode("B-1234");
        boolean result = unitUnderTest.isValid(r, null);
        assertThat(result).isFalse();
    }
}