package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.ApiZipcodeApplicationTests;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



class ZipCodeServiceTest extends ApiZipcodeApplicationTests {

    public static final String ZIP_CODE_BR_SUCCESS_SEND = "73255903";
    public static final String ZIP_CODE_BR_SUCCESS_RECEIVE = "73255-903";


    @Autowired
    private ZipCodeService service;

//    @Test
//    void should_be_success_when_send_valid_zip_br_service(){
//        assertNotNull(getRestTemplate());
//        assertNotNull(service);
//        ZipCodeDTO zipCodeByCountry = service.findZipCodeByCountry(CountryEnum.BRAZIL, ZIP_CODE_BR_SUCCESS_SEND);
//        assertEquals(zipCodeByCountry.getCode(),ZIP_CODE_BR_SUCCESS_RECEIVE);
//    }
//
//    @Test
//    void should_be_error_when_send_invalid_zip_br_service(){
//        assertNotNull(getRestTemplate());
//        assertNotNull(service);
//        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
//            service.findZipCodeByCountry(CountryEnum.BRAZIL, "");
//        });
//        assertEquals(illegalArgumentException.getMessage(),"Invalid zipcode");
//    }

//    @Test
//    void should_be_error_when_send_invalid_country_br_service(){
//        assertNotNull(getRestTemplate());
//        assertNotNull(service);
//        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
//            service.findZipCodeByCountry("", ZIP_CODE_BR_SUCCESS_SEND);
//        });
//        assertEquals(illegalArgumentException.getMessage(),"Invalid zipcode");
//    }

//    @Test
//    void should_be_error_when_send_invalid_country_br_service2(){
//        assertNotNull(getRestTemplate());
//        assertNotNull(service);
//        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
//            service.findZipCodeByCountry("", "");
//        });
//        assertEquals(illegalArgumentException.getMessage(),"Invalid zipcode");
//    }
}
