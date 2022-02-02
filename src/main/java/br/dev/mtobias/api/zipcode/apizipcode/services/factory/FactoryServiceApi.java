package br.dev.mtobias.api.zipcode.apizipcode.services.factory;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.ServiceCountry;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.ServiceCountryBR;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.ServiceCountryPT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryServiceApi {
    @Autowired
    private ServiceCountryBR apiBr;

    @Autowired
    private ServiceCountryPT apiPt;

    public ZipCodeDTO findZipCodeByCountry(String country, String zipCode ){
        if(country.equals("br")){
            return findZip(apiBr, zipCode);
        }else if(country.equals("pt")){
             return findZip(apiPt, zipCode);
        }
        return new ZipCodeDTO();
    }

    private ZipCodeDTO findZip(ServiceCountry service, String zipCode){
        return service.findZip(zipCode);
    }

}