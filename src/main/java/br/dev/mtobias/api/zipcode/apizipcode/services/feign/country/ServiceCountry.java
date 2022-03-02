package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;

public interface ServiceCountry {
    ZipCodeDTO findZip(String zipCode);
}
