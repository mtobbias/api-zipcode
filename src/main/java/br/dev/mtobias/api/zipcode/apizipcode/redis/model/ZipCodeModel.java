package br.dev.mtobias.api.zipcode.apizipcode.redis.model;

import java.io.Serializable;

import br.dev.mtobias.api.zipcode.apizipcode.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "zipCodeModel")
@Getter
@Setter
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

    public static String createId(String country, String zipCode) {
        return country+"_"+ Utils.removeNoNumbers(zipCode);
    }

    @Override
    public String toString() {
         return country+"_"+code;
    }
}
