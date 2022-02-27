package br.dev.mtobias.api.zipcode.apizipcode.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/swagger-ui/");
    }

    @Bean
    public Docket fromApi(){
        return new Docket(DocumentationType.OAS_30).
                select().
                apis(RequestHandlerSelectors.basePackage("br.dev.mtobias.api.zipcode.apizipcode.rest")).
                paths(PathSelectors.ant("/**")).
                build();
    }
}
