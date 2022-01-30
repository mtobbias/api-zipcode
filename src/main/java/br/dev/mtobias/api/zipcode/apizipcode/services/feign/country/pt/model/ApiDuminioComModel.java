package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.model;

import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.FeignApiModel;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ApiDuminioComModel implements FeignApiModel {
    @JsonAlias("ID")
    private String id;
    @JsonAlias("CodigoPostal")
    private String codigoPostal;
    @JsonAlias("Morada")
    private String morada;
    @JsonAlias("Localidade")
    private String localidade;
    @JsonAlias("NumeroPorta")
    private String numeroPorta;
    @JsonAlias("Freguesia")
    private String freguesia;
    @JsonAlias("Concelho")
    private String concelho;
    @JsonAlias("CodigoDistrito")
    private String codigoDistrito;
    @JsonAlias("Distrito")
    private String distrito;
    @JsonAlias("Latitude")
    private String latitude;
    @JsonAlias("Longitude")
    private String longitude;
}
