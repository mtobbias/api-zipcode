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
        ZipCodeDTO forObject = requestZipCode(BRAZIL, BR_ZIP_VALID);
        assertThat(forObject).isNotNull();
        assertThat(forObject.getPostalCode()).isEqualTo(BR_ZIP_VALID_RECEIVER);
    }

    @Test
    void should_be_success_when_send_valid_zip_pt() {
        assertThat(getRestTemplate()).isNotNull();
        ZipCodeDTO forObject = requestZipCode(PORTUGAL, PT_ZIP_VALID);
        assertThat(forObject).isNotNull();
        assertThat(forObject.getPostalCode()).isEqualTo(PT_ZIP_VALID_RECEIVER);
    }


    @Test
    void should_be_null_when_send_invalid_zip_br() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(BRAZIL, BR_ZIP_INVALID), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    void should_be_null_when_send_invalid_zip_pt(){
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(PORTUGAL, PT_ZIP_INVALID), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    void should_be_null_when_send_invalid_country_with_zip_br() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(COUNTRY_INVALID, BR_ZIP_VALID), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void should_be_null_when_send_invalid_country_with_zip_pt() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(COUNTRY_INVALID, PT_ZIP_VALID), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void should_be_null_when_send_cross_country_with_valid_pt_zip() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(BRAZIL, PT_ZIP_VALID), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void should_be_null_when_send_cross_country_with_valid_br_zip() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(BRAZIL, BR_ZIP_VALID), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void should_be_null_when_send_invalid_zip_size() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(BRAZIL, ERROR_ZIP_6), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void should_be_null_when_send_invalid_zip_size_8() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(BRAZIL, ERROR_ZIP_8), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void should_be_null_when_send_invalid_country_size() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(ERROR_COUNTRY_3, BR_ZIP_VALID), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void should_be_null_when_send_valid_country_not() {
        assertThat(getRestTemplate()).isNotNull();
        ResponseEntity<String> responseEntity = this.getRestTemplate().exchange(getUrlFromZipCode(ERROR_COUNTRY_VALID_NOT_IMPLEMENTED, BR_ZIP_VALID), HttpMethod.GET, new HttpEntity<Object>(""), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
