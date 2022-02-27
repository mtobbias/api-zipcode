package br.dev.mtobias.api.zipcode.apizipcode.rest.dto;

import br.dev.mtobias.api.zipcode.apizipcode.validators.CountryValidator;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@RedisHash("zipCodeDTO")
public class ZipCodeDTO {

    @NotNull(message = "id not to be empty or null")
    @Length(max = 8, min = 7, message = "is should be between 7 and 8")
    @Id
    @NotEmpty(message = "id not to be empty or null")
    @NotBlank(message = "id not to be empty or null")
    @JsonProperty("postal_code")
    private String postalCode;
    @Length(max = 2, min = 2, message = "is should be 2 length")
    @NotNull(message = "country not to be null")
    @NotEmpty(message = "id not to be empty or null")
    @NotBlank(message = "id not to be empty or null")
    @CountryValidator(message = "invalid country")
    @JsonProperty("country_code")
    private String country;
    private String district;
    private String city;
    private String state;
    private String address;

    public ZipCodeDTO(String country, String postalCode) {
        this.country = country.toLowerCase();
        this.postalCode = postalCode.toLowerCase();
    }
}
