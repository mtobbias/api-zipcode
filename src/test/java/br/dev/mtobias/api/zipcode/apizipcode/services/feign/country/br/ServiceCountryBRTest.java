package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br;

import br.dev.mtobias.api.zipcode.apizipcode.ApiZipcodeApplicationTests;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

 class ServiceCountryBRTest  extends ApiZipcodeApplicationTests {

    @Autowired
    private ServiceCountryBR serviceCountryBR;

    @Test
    void valid(){
        assertNotNull(serviceCountryBR);
        ZipCodeDTO zipCodeByCountry = serviceCountryBR.findZip(BR_ZIP_VALID);
        assertEquals(BR_ZIP_VALID_RECEIVER, zipCodeByCountry.getPostalCode());
    }
    @Test
     void invalid(){
        assertNotNull(serviceCountryBR);
        ZipCodeDTO zipCodeByCountry = serviceCountryBR.findZip(BR_ZIP_INVALID);
        assertNull(zipCodeByCountry.getPostalCode());
    }
}
