package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.ApiZipcodeApplicationTests;
import br.dev.mtobias.api.zipcode.apizipcode.exceptions.NotFoundException;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ZipCodeServiceTest extends ApiZipcodeApplicationTests {



    @Autowired
    private ZipCodeService service;

    @Test
    void should_success_when_send_valid_zip_and_country_brazil() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        ZipCodeDTO zipCodeByCountry = service.findZipCodeByCountry(new ZipCodeDTO(BRAZIL, BR_ZIP_VALID));
        assertEquals(BR_ZIP_VALID_RECEIVER, zipCodeByCountry.getPostalCode());
    }

    @Test
    void should_success_when_send_valid_zip_and_country_portugal() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        ZipCodeDTO zipCodeByCountry = service.findZipCodeByCountry(new ZipCodeDTO(PORTUGAL, PT_ZIP_VALID));
        assertEquals(PT_ZIP_VALID_RECEIVER, zipCodeByCountry.getPostalCode());
    }

    @Test
    void should_error_when_send_invalid_zip() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        assertThrows(IllegalArgumentException.class, () -> service.findZipCodeByCountry(INVALID_ZIP_CODE_DTO));
    }

    @Test
    void should_error_when_send_invalid_country() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        assertThrows(IllegalArgumentException.class, () -> service.findZipCodeByCountry(INVALID_COUNTRY_DTO));
    }

    @Test
    void should_error_when_send_invalid_zip_and_country() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        assertThrows(IllegalArgumentException.class, () -> service.findZipCodeByCountry(INVALID_ZIP_COUNTRY_DTO));
    }

    @Test
    void should_error_when_send_not_found_zip() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        assertThrows(NotFoundException.class, () -> service.findZipCodeByCountry(NOTFOUND_ZIP_CODE_DTO));
    }
}
