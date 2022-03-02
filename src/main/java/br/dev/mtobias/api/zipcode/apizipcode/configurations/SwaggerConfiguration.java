package br.dev.mtobias.api.zipcode.apizipcode.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Value("${application.name}")
    private String applicationName;

    @Value("${application.description}")
    private String applicationDescription;

    @Value("${application.version}")
    private String applicationVersion;

    @Value("${application.terms}")
    private String applicationTerms;

    @Value("${application.license}")
    private String applicationLicense;

    @Value("${application.url}")
    private String applicationUrl;


    @Value("${application.contact.name}")
    private String applicationContactName;

    @Value("${application.contact.url}")
    private String applicationContactUrl;

    @Value("${application.contact.email}")
    private String applicationContactEmail;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui/");
    }

    @Bean
    public Docket fromApi() {
        return new Docket(DocumentationType.OAS_30).
                select().
                apis(RequestHandlerSelectors.basePackage("br.dev.mtobias.api.zipcode.apizipcode.rest")).
                paths(PathSelectors.ant("/**")).
                build().
                apiInfo(getInfo());
    }

    private ApiInfo getInfo() {
        return new ApiInfo(applicationName,
                applicationDescription,
                applicationVersion,
                applicationTerms,
                getContact(),
                applicationLicense,
                applicationUrl,
                Collections.emptyList());
    }

    private Contact getContact() {
        return new Contact(
                applicationContactName,
                applicationContactUrl,
                applicationContactEmail);
    }

}
