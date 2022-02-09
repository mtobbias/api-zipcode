package br.dev.mtobias.api.zipcode.apizipcode.mapper;

import br.dev.mtobias.api.zipcode.apizipcode.redis.model.ZipCodeModel;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model.ApiCepComModel;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.model.ApiDuminioComModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {br.dev.mtobias.api.zipcode.apizipcode.utils.Utils.class})
public interface ZipCodeMapper {
    ZipCodeMapper INSTANCE = Mappers.getMapper(ZipCodeMapper.class);

    ZipCodeDTO fromModel(ApiCepComModel model);

    @Mapping(source ="codigoPostal", target = "code" )
    @Mapping(source ="morada", target = "address")
    @Mapping(source ="freguesia", target = "district")
    @Mapping(source ="distrito", target = "city")
    @Mapping(source ="codigoDistrito", target = "state")
    ZipCodeDTO fromModel(ApiDuminioComModel model);

    @Mapping(target ="id", expression = "java(br.dev.mtobias.api.zipcode.apizipcode.utils.Utils.generateIdZipCodeRedis(zipCodeByCountry.getCountry(),zipCodeByCountry.getCode()))")
    ZipCodeModel toModelRedis(ZipCodeDTO zipCodeByCountry);

    ZipCodeDTO toDtoFromModel (ZipCodeModel model);
}
