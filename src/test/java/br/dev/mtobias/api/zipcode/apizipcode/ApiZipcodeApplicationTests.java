package br.dev.mtobias.api.zipcode.apizipcode;
import br.dev.mtobias.api.zipcode.apizipcode.mapper.ZipCodeMapperImpl;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
        classes = {ApiZipcodeApplication.class, ZipCodeMapperImpl.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
public abstract class ApiZipcodeApplicationTests {
    protected static final String BRAZIL ="br";
    protected static final String PORTUGAL ="PT";

    public static final String COUNTRY_INVALID = "0";

    protected static final String ERROR_ZIP_6 = "000000";
    protected static final String ERROR_ZIP_8 = "00000000";
    protected static final String ERROR_COUNTRY_3 = "BRR";
    protected static final String ERROR_COUNTRY_VALID_NOT_IMPLEMENTED = "jp";

    protected static final String BR_ZIP_INVALID = "0";
    protected static final String BR_ZIP_VALID = "73255903";
    protected static final String BR_ZIP_VALID_RECEIVER = "73255-903";

    protected static final String PT_ZIP_INVALID = "0";
    protected static final String PT_ZIP_VALID = "9700413";
    protected static final String PT_ZIP_VALID_RECEIVER = "9700-413";


    protected static final ZipCodeDTO INVALID_ZIP_CODE_DTO = new ZipCodeDTO(BRAZIL, "");
    protected static final ZipCodeDTO INVALID_COUNTRY_DTO = new ZipCodeDTO("", BR_ZIP_VALID);
    protected static final ZipCodeDTO INVALID_ZIP_COUNTRY_DTO = new ZipCodeDTO("", "");

    protected static final ZipCodeDTO NOTFOUND_ZIP_CODE_DTO = new ZipCodeDTO(BRAZIL, ERROR_ZIP_8);

    @LocalServerPort
    protected Integer port;

    @Autowired
    private TestRestTemplate restTemplate;



    protected TestRestTemplate getRestTemplate() {
        return restTemplate;
    }
}
