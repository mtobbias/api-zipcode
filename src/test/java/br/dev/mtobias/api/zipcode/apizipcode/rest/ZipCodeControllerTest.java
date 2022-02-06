package br.dev.mtobias.api.zipcode.apizipcode.rest;

import br.dev.mtobias.api.zipcode.apizipcode.ApiZipcodeApplicationTests;
import br.dev.mtobias.api.zipcode.apizipcode.enums.CountryEnum;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;



 class ZipCodeControllerTest extends ApiZipcodeApplicationTests {

    public static final String ZIP_CODE_BR_INVALID_SEND = "0";

    public static final String ZIP_CODE_BR_SUCCESS_SEND = "73255903";
    public static final String ZIP_CODE_BR_SUCCESS_RECEIVE = "73255-903";

    public static final String ZIP_CODE_PT_INVALID_SEND = "0";

    public static final String ZIP_CODE_PT_SUCCESS_SEND = "9700413";
    public static final String ZIP_CODE_PT_SUCCESS_RECEIVE = "9700-413";

    private ZipCodeDTO requestZipCode(CountryEnum country, String zip) {
        String url = getUrlFromZipCode(country.getCountry(), zip);
        return this.getRestTemplate().getForObject(url, ZipCodeDTO.class);
    }

    private String getUrlFromZipCode(String country,String zipCode){
        return "http://localhost:" + getPort() + "/v1/api/zips/"+country+"/"+zipCode;
    }

    @Test
    void should_be_success_when_send_valid_zip_br(){
        assertThat(getRestTemplate()).isNotNull();
        ZipCodeDTO forObject = requestZipCode(CountryEnum.BRAZIL, ZIP_CODE_BR_SUCCESS_SEND);
        assertThat(forObject).isNotNull();
        assertThat(forObject.getCode()).isEqualTo(ZIP_CODE_BR_SUCCESS_RECEIVE);
    }

    @Test
    void should_be_null_when_send_invalid_zip_br(){
        assertThat(getRestTemplate()).isNotNull();
        ZipCodeDTO forObject = requestZipCode(CountryEnum.BRAZIL, ZIP_CODE_BR_INVALID_SEND);
        assertThat(forObject).isNull();
    }


    @Test
    void should_be_success_when_send_valid_zip_pt(){
        assertThat(getRestTemplate()).isNotNull();
        ZipCodeDTO forObject = requestZipCode(CountryEnum.PORTUGAL,ZIP_CODE_PT_SUCCESS_SEND);
        assertThat(forObject.getCode()).isEqualTo(ZIP_CODE_PT_SUCCESS_RECEIVE);
    }

    @Test
    void should_be_null_when_send_invalid_zip_pt(){
        assertThat(getRestTemplate()).isNotNull();
        ZipCodeDTO forObject = requestZipCode(CountryEnum.PORTUGAL,ZIP_CODE_PT_INVALID_SEND);
        assertThat(forObject).isNull();
    }

}
