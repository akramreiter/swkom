package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CityValidatorTest {

    private final CityValidator unitUnderTest = new CityValidator();

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
        r.setCity("Wien");
        boolean result = unitUnderTest.isValid(r, null);
        assertThat(result).isTrue();
    }

    @Test
    public void austriaWithValidPatternWithSpace() {
        RecipientEntity r = new RecipientEntity();
        r.setCountry("Austria");
        r.setCity("Wi en");
        boolean result = unitUnderTest.isValid(r, null);
        assertThat(result).isTrue();
    }

    @Test
    public void austriaWithValidPatternWithDash() {
        RecipientEntity r = new RecipientEntity();
        r.setCountry("Austria");
        r.setCity("Wi-en");
        boolean result = unitUnderTest.isValid(r, null);
        assertThat(result).isTrue();
    }

    @Test
    public void austriaWithValidPatternWithSlash() {
        RecipientEntity r = new RecipientEntity();
        r.setCountry("Austria");
        r.setCity("Wi/en");
        boolean result = unitUnderTest.isValid(r, null);
        assertThat(result).isTrue();
    }

    @Test
    public void austriaWithInvalidPattern() {
        RecipientEntity r = new RecipientEntity();
        r.setCountry("Austria");
        r.setCity("W1en");
        boolean result = unitUnderTest.isValid(r, null);
        assertThat(result).isFalse();
    }

}