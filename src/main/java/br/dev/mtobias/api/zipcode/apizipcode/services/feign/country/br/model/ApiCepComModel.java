package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model;

import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.FeignApiModel;
import lombok.Data;

@Data
public class ApiCepComModel implements FeignApiModel {
    private String code;
    private String address;
    private String district;
    private String city;
    private String state;
}
