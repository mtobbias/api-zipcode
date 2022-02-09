package br.dev.mtobias.api.zipcode.apizipcode.redis.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "zipCodeModel")
public class ZipCodeModel implements Serializable {
    @Id
    @Indexed
    private String id;
    private String code;
    private String address;
    private String district;
    private String city;
    private String state;
    private String country;

    public ZipCodeModel(String country, String zipCode) {
        this.country =country;
        this.code = zipCode;
    }

    public static String createId(String country, String zipCode) {
        return new ZipCodeModel(country,zipCode).toString();
    }

    @Override
    public String toString() {
         return country+"_"+code;
    }
}
