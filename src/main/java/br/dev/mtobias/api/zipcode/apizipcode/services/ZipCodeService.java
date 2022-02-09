package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.enums.CountryEnum;
import br.dev.mtobias.api.zipcode.apizipcode.mapper.ZipCodeMapper;
import br.dev.mtobias.api.zipcode.apizipcode.redis.model.ZipCodeModel;
import br.dev.mtobias.api.zipcode.apizipcode.redis.repository.ZipCodeRepository;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.factory.FactoryServiceApi;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ZipCodeService {

    private final FactoryServiceApi factoryServiceApi;
    private final ZipCodeRepository repository;
    private final ZipCodeMapper mapper;


    public ZipCodeDTO findZipCodeByCountry(CountryEnum country, String zipCode) {
            return findZipCodeByCountry(country.getCountry(),zipCode);
    }
    public ZipCodeDTO findZipCodeByCountry(String country,String zipCode) {
        validateData(zipCode,country);
        Optional<ZipCodeModel> byId = repository.findById(ZipCodeModel.createId(country, zipCode));
        if(byId.isPresent()){
            return mapper.toDtoFromModel(byId.get());
        }
        ZipCodeDTO zipCodeByCountry = factoryServiceApi.findZipCodeByCountry(country, zipCode);
        ZipCodeModel zipCodeModel = mapper.toModelRedis(zipCodeByCountry);
        repository.save(zipCodeModel);
        return zipCodeByCountry;
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
