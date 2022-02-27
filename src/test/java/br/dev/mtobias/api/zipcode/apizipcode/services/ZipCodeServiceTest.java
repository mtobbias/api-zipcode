package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.ApiZipcodeApplicationTests;
import br.dev.mtobias.api.zipcode.apizipcode.exceptions.NotFoundException;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class ZipCodeServiceTest extends ApiZipcodeApplicationTests {

    public static final String NOTFOUND_ZIP_CODE_BR_SUCCESS_SEND = "00000000";
    public static final String ZIP_CODE_BR_SUCCESS_SEND = "73255903";
    public static final String ZIP_CODE_BR_SUCCESS_RECEIVE = "73255-903";
    public static final ZipCodeDTO INVALID_ZIP_CODE_DTO = new ZipCodeDTO(BRAZIL, "");
    public static final ZipCodeDTO INVALID_COUNTRY_DTO = new ZipCodeDTO("", ZIP_CODE_BR_SUCCESS_SEND);
    public static final ZipCodeDTO INVALID_ZIP_COUNTRY_DTO = new ZipCodeDTO("", "");

    public static final ZipCodeDTO NOTFOUND_ZIP_CODE_DTO = new ZipCodeDTO(BRAZIL, NOTFOUND_ZIP_CODE_BR_SUCCESS_SEND);


    @Autowired
    private ZipCodeService service;

    @Test
    void should_be_success_when_send_valid_zip_br_service() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        ZipCodeDTO zipCodeByCountry = service.findZipCodeByCountry(new ZipCodeDTO(BRAZIL, ZIP_CODE_BR_SUCCESS_SEND));
        assertEquals(ZIP_CODE_BR_SUCCESS_RECEIVE, zipCodeByCountry.getPostalCode());
    }

    @Test
    void should_be_error_when_send_invalid_zip_br_service() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        assertThrows(IllegalArgumentException.class, () -> service.findZipCodeByCountry(INVALID_ZIP_CODE_DTO));
    }

    @Test
    void should_be_error_when_send_invalid_country_br_service() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        assertThrows(IllegalArgumentException.class, () -> service.findZipCodeByCountry(INVALID_COUNTRY_DTO));
    }

    @Test
    void should_be_error_when_send_invalid_zip_and_country_br_service() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        assertThrows(IllegalArgumentException.class, () -> service.findZipCodeByCountry(INVALID_ZIP_COUNTRY_DTO));
    }


    @Test
    void should_be_error_when_send_not_found_country_br_service() {
        assertNotNull(getRestTemplate());
        assertNotNull(service);
        assertThrows(NotFoundException.class, () -> service.findZipCodeByCountry(NOTFOUND_ZIP_CODE_DTO));
    }
}
