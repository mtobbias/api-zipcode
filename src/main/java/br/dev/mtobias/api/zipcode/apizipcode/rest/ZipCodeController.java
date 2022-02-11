package br.dev.mtobias.api.zipcode.apizipcode.rest;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.ZipCodeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("v1/api/zips")
public class ZipCodeController {

    @Value("${ptapi.key}")
    private String apikey;
    private ZipCodeService zipCodeService;

    public ZipCodeController(ZipCodeService zipCodeService) {
        this.zipCodeService = zipCodeService;
    }

    @GetMapping("/{country}/{zipCode}")
    public ResponseEntity<ZipCodeDTO> index(@PathVariable("country") String country, @PathVariable("zipCode") String zipCode){
        ZipCodeDTO zipCodeDto = null;
        try {
             zipCodeDto = zipCodeService.findZipCodeByCountry(country,zipCode);
        }catch (IllegalArgumentException err){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(zipCodeDto);
    }

    @GetMapping("/abc")
    public ResponseEntity<String> index2(){
        return ResponseEntity.ok(apikey);
    }


}