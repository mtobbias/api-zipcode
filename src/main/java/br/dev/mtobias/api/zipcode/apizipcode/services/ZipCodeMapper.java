package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model.ApiCepComModel;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.model.ApiDuminioComModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ZipCodeMapper {
    ZipCodeMapper INSTANCE = Mappers.getMapper(ZipCodeMapper.class);

    ZipCodeDTO fromModel(ApiCepComModel model);

    @Mapping(source ="codigoPostal", target = "code" )
    @Mapping(source ="morada", target = "address")
    @Mapping(source ="freguesia", target = "district")
    @Mapping(source ="distrito", target = "city")
    @Mapping(source ="codigoDistrito", target = "state")
    ZipCodeDTO fromModel(ApiDuminioComModel model);

}
