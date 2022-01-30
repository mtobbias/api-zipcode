package br.dev.mtobias.api.zipcode.apizipcode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Marcelo Tobias <marcelo.tobbias@gmail.com>
 *
 */
@RequestMapping("/")
@SpringBootApplication
@EnableFeignClients()
public class ApiZipcodeApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ApiZipcodeApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/index.html");
    }

    @GetMapping("/")
    public ResponseEntity<String> index(){
        return  ResponseEntity.ok("api-codezip");
    }

}
