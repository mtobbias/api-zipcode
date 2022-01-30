package br.dev.mtobias.api.zipcode.apizipcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Marcelo Tobias <marcelo.tobbias@gmail.com>
 *
 */
@SpringBootApplication
@EnableFeignClients()
@EnableSwagger2
public class ApiZipcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiZipcodeApplication.class, args);
    }

}
