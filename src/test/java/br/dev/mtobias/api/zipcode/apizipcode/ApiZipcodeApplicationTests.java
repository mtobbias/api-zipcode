package br.dev.mtobias.api.zipcode.apizipcode;
import br.dev.mtobias.api.zipcode.apizipcode.mapper.ZipCodeMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
@SpringBootTest(
        classes = {ApiZipcodeApplication.class, ZipCodeMapperImpl.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class ApiZipcodeApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    protected int getPort() {
        return port;
    }

    protected TestRestTemplate getRestTemplate() {
        return restTemplate;
    }
}
