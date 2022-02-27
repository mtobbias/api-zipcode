package br.dev.mtobias.api.zipcode.apizipcode.rest;

import br.dev.mtobias.api.zipcode.apizipcode.ApiZipcodeApplicationTests;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


class ZipCodeControllerTest extends ApiZipcodeApplicationTests {

    public static final String ZIP_CODE_BR_INVALID_SEND = "0";

    public static final String ZIP_CODE_BR_SUCCESS_SEND = "73255903";
    public static final String ZIP_CODE_BR_SUCCESS_RECEIVE = "73255-903";

    public static final String ZIP_CODE_PT_INVALID_SEND = "0";

    public static final String ZIP_CODE_PT_SUCCESS_SEND = "9700413";
    public static final String ZIP_CODE_PT_SUCCESS_RECEIVE = "9700-413";
    private String url = "";

    private ZipCodeDTO requestZipCode(String country, String zip) {
        String url = getUrlFromZipCode(country, zip);
        return this.getRestTemplate().getForObject(url, ZipCodeDTO.class);
    }

    private String getUrlFromZipCode(String country, String zipCode) {
        if (this.url.isEmpty()) {
            this.url = "http://localhost:" + port + "/v1/api/zips/";
        }
        return this.url + country + "/" + zipCode;
    }
    @Test
    void should_be_success_when_send_valid_zip_br() {
        assertThat(getRestTemplate()).isNotNull();
        ZipCodeDTO forObject = requestZipCode(BRAZIL, ZIP_CODE_BR_SUCCESS_SEND);
        assertThat(forObject).isNotNull();
        assertThat(forObject.getPostalCode()).isEqualTo(ZIP_CODE_BR_SUCCESS_RECEIVE);
    }

    @Test
    void should_be_null_when_send_invalid_zip_br() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(BRAZIL, ZIP_CODE_BR_INVALID_SEND), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void should_be_success_when_send_valid_zip_pt() {
        assertThat(getRestTemplate()).isNotNull();
        ZipCodeDTO forObject = requestZipCode(PORTUGAL, ZIP_CODE_PT_SUCCESS_SEND);
        assertThat(forObject).isNotNull();
        assertThat(forObject.getPostalCode()).isEqualTo(ZIP_CODE_PT_SUCCESS_RECEIVE);
    }
    @Test
    void should_be_null_when_send_invalid_zip_pt(){
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(PORTUGAL, ZIP_CODE_PT_INVALID_SEND), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
