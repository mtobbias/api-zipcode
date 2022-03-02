package br.dev.mtobias.api.zipcode.apizipcode.mapper;

import br.dev.mtobias.api.zipcode.apizipcode.redis.model.ZipCodeModel;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model.ApiCepComModel;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.model.ApiDuminioComModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {br.dev.mtobias.api.zipcode.apizipcode.utils.Utils.class})
public interface ZipCodeMapper {
    @Mapping(source ="code", target = "postalCode" )
    ZipCodeDTO fromModel(ApiCepComModel model);

    @Mapping(source ="codigoPostal", target = "postalCode" )
    @Mapping(source ="morada", target = "address")
    @Mapping(source ="freguesia", target = "district")
    @Mapping(source ="concelho", target = "city")
    @Mapping(source ="distrito", target = "state")
    ZipCodeDTO fromModel(ApiDuminioComModel model);

    @Mapping(target ="id", expression = "java(br.dev.mtobias.api.zipcode.apizipcode.utils.Utils.generateIdZipCodeRedis(zipCodeByCountry.getCountry(),zipCodeByCountry.getPostalCode()))")
    @Mapping(source = "postalCode", target = "code")
    ZipCodeModel modelToDTO(ZipCodeDTO zipCodeByCountry);

    @Mapping(source = "code", target = "postalCode")
    ZipCodeDTO dtoToModel(ZipCodeModel model);
}
