package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.FeignApiModel;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.ApiCepCom;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model.ApiCepComModel;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.ApiDuminioCom;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.model.ApiDuminioComModel;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryServiceApi {
    @Autowired
    private ApiCepCom apiBr;

    @Autowired
    private ApiDuminioCom apiPt;

    public  ZipCodeDTO findZipCodeByCountry(String country,String zipCode ){
        if(country.equals("br")){
            ApiCepComModel zip = this.apiBr.findZip(zipCode);
            return createDto(country, zip);
        }else if(country.equals("pt")){
            List<ApiDuminioComModel> zip = this.apiPt.findZip(zipCode);
            return createDto(country, zip.get(0));
        }
//        FeignApiModel[] zip = getService(country).findZip(zipCode);
        return null;
    }


    private ZipCodeDTO createDto(String country, FeignApiModel zip) {
        ZipCodeDTO zipCodeDTO = null;
        if(zip instanceof ApiCepComModel){
                    zipCodeDTO = ZipCodeMapper.INSTANCE.fromModel((ApiCepComModel) zip);
        }
        if(zip instanceof ApiDuminioComModel){
                   zipCodeDTO = ZipCodeMapper.INSTANCE.fromModel((ApiDuminioComModel) zip);
        }

        if(Objects.isNull(zipCodeDTO.getCode())){
            throw new IllegalArgumentException("ZipCode not found for country "+country);
        }
        zipCodeDTO.setCountry(country);
        return zipCodeDTO;
    }

}
