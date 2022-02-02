package br.dev.mtobias.api.zipcode.apizipcode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Marcelo Tobias <marcelo.tobbias@gmail.com>
 *
 */
@SpringBootApplication
@EnableFeignClients()
public class ApiZipcodeApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ApiZipcodeApplication.class, args);
    }


}
