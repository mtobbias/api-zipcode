package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model;

import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.FeignApiModel;
import lombok.Data;

/**
 * @implNote this is a model of https://apicep.com/api-de-consulta/
 * @see https://apicep.com/api-de-consulta/
 */
@Data
public class ApiCepComModel implements FeignApiModel {
    private int status;
    private String code;
    private String state;
    private String city;
    private String district;
    private String address;
}
