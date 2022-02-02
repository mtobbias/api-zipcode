package br.dev.mtobias.api.zipcode.apizipcode.services;

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
        ZipCodeDTO zip = null;
        if(country.equals("br")){
            zip = findZip(apiBr, zipCode);
        }else if(country.equals("pt")){
             zip = findZip(apiPt, zipCode);
        }
        zip.setCountry(country);
        return zip;
    }

    private ZipCodeDTO findZip(ServiceCountry service, String zipCode){
        ZipCodeDTO zip = service.findZip(zipCode);
        return  zip;
    }

}
