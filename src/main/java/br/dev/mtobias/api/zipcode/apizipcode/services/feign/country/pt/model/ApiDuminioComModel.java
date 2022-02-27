package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.model;

import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.FeignApiModel;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ApiDuminioComModel implements FeignApiModel {
    @JsonAlias("CodigoPostal")
    private String codigoPostal;
    @JsonAlias("Morada")
    private String morada;
    @JsonAlias("Freguesia")
    private String freguesia;
    @JsonAlias("Concelho")
    private String concelho;
    @JsonAlias("Distrito")
    private String distrito;
}
