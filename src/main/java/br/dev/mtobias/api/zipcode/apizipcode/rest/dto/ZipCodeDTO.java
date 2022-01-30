package br.dev.mtobias.api.zipcode.apizipcode.rest.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("zipCodeDTO")
public class ZipCodeDTO {
    @Id
    private String code;
    private String address;
    private String district;
    private String city;
    private String state;
    private String country;
}
