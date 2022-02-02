package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.factory.FactoryServiceApi;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ZipCodeService {

    private final FactoryServiceApi factoryServiceApi;
    public ZipCodeDTO findZipCodeByCountry(String country,String zipCode) {
        validateData(zipCode,country);
        return factoryServiceApi.findZipCodeByCountry(country, zipCode);
    }

    private void validateData(String zipCode, String country) {
        if(
                Objects.isNull(zipCode) ||
                        Objects.isNull(country) ||
                        zipCode.isEmpty() ||
                        country.isEmpty()

        ){
            throw  new IllegalArgumentException("Invalid zipcode");
        }
    }
}
