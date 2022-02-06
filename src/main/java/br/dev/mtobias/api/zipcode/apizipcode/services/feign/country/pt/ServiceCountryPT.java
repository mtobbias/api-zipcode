package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.mapper.ZipCodeMapper;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.ServiceCountry;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.model.ApiDuminioComModel;
import feign.codec.DecodeException;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceCountryPT implements ServiceCountry {

    private final ApiDuminioCom service;
    private final ZipCodeMapper mapper;

    public ApiDuminioComModel findAllZip(String zipCode) {
        Optional<List<ApiDuminioComModel>> allZip;
        try{
            allZip = service.findAllZip(zipCode);
            List<ApiDuminioComModel> apiDuminioComModels = allZip.orElseThrow(() -> new IllegalArgumentException(""));
            return apiDuminioComModels.get(0);
        }catch (DecodeException e){
                throw new IllegalArgumentException("");
        }
    }

    @Override
    public ZipCodeDTO findZip(String zipCode) {
        ApiDuminioComModel zipModel = findAllZip(zipCode);
        return mapper.fromModel(zipModel);
    }
}
