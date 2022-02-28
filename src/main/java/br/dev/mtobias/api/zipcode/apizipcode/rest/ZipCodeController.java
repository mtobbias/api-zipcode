package br.dev.mtobias.api.zipcode.apizipcode.rest;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.ZipCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("v1/api/zips")
@SwaggerDefinition(
        tags = {
                @Tag(name = "name", description = "asdasdasd")
        }
)
public class ZipCodeController {

    @Value("${ptapi.key}")
    private String apikey;
    private ZipCodeService zipCodeService;

    public ZipCodeController(ZipCodeService zipCodeService) {
        this.zipCodeService = zipCodeService;
    }


    @GetMapping("/{country}/{zipCode}")
    public ResponseEntity<ZipCodeDTO> index(@PathVariable("country") String country, @PathVariable("zipCode") String zipCode){
        return ResponseEntity.ok(zipCodeService.findZipCodeByCountry(new ZipCodeDTO(country,zipCode)));
    }

}