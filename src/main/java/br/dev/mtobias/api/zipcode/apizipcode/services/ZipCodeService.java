package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.enums.CountryEnum;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.factory.FactoryServiceApi;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ZipCodeService {

    private final FactoryServiceApi factoryServiceApi;

    public ZipCodeDTO findZipCodeByCountry(CountryEnum country, String zipCode) {
            return findZipCodeByCountry(country.getCountry(),zipCode);
    }
    public ZipCodeDTO findZipCodeByCountry(String country,String zipCode) {
        validateData(zipCode,country);
        return factoryServiceApi.findZipCodeByCountry(country, zipCode);
    }

    private void validateData(String zipCode, String country) {
        if(
                        zipCode.isEmpty() ||
                        country.isEmpty()
        ){
            throw  new IllegalArgumentException("Invalid zipcode");
        }
    }
}
