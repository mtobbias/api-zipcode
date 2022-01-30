package br.dev.mtobias.api.zipcode.apizipcode;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.ZipCodeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiZipcodeApplicationTests {
    public static final String ZIP_CODE_BR_SUCCESS_SEND = "73255903";
    public static final String ZIP_CODE_BR_SUCCESS_RECEIVE = "73255-903";

    public static final String ZIP_CODE_PT_SUCCESS_SEND = "9700413";
    public static final String ZIP_CODE_PT_SUCCESS_RECEIVE = "9700-413";


    @Autowired
    private ZipCodeService zipCodeService;

    @Test()
    void sucess() {
        ZipCodeDTO zipDto = zipCodeService.findZipCodeByCountry(ZIP_CODE_BR_SUCCESS_SEND, "br");
        Assertions.assertEquals(ZIP_CODE_BR_SUCCESS_RECEIVE, zipDto.getCode());
    }

    void sucessPT() {
        ZipCodeDTO zipDto = zipCodeService.findZipCodeByCountry(ZIP_CODE_PT_SUCCESS_SEND, "pt");
        Assertions.assertEquals(ZIP_CODE_PT_SUCCESS_RECEIVE, zipDto.getCode());
    }

    @Test()
    void sholdReturnError() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
            ZipCodeDTO zipDto = zipCodeService.findZipCodeByCountry("", "br");
        });
        Assertions.assertEquals("Invalid zipcode",thrown.getMessage());
    }
}
