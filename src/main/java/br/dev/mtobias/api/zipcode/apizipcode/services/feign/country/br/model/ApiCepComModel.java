package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model;

import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.FeignApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @implNote this is a model of https://apicep.com/api-de-consulta/
 * @see https://apicep.com/api-de-consulta/
 */
@Getter
@Setter
public class ApiCepComModel implements FeignApiModel {
    private String code;
    private String state;
    private String city;
    private String district;
    private String address;
}
