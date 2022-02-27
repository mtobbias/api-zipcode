package br.dev.mtobias.api.zipcode.apizipcode.services.factory;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.ServiceCountry;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.ServiceCountryBR;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.ServiceCountryPT;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FactoryServiceApi {

    private final ServiceCountryBR serviceCountryBR;
    private final ServiceCountryPT serviceCountryPT;

    public Optional<ZipCodeDTO> findZipCodeByCountry(ZipCodeDTO zipFind){
        ZipCodeDTO zipReturn = findZip(getServiceByCountry(zipFind.getCountry()),zipFind.getPostalCode());
        zipReturn.setCountry(zipFind.getCountry());
        return Optional.of(zipReturn);
    }

    private ZipCodeDTO findZip(ServiceCountry service, String zipCode){
        return service.findZip(zipCode);
    }
    public ServiceCountry getServiceByCountry(String byCountry){
        switch (byCountry.toLowerCase()){
            case "pt": return serviceCountryPT;
            case "br": return serviceCountryBR;
            default: return null;
        }
    }
}
