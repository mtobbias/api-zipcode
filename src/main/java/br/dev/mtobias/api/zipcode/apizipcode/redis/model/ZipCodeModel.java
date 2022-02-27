package br.dev.mtobias.api.zipcode.apizipcode.redis.model;

import java.io.Serializable;

import br.dev.mtobias.api.zipcode.apizipcode.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    public static String createId(String country, String zipCode) {
        return country+"_"+ Utils.removeNoNumbers(zipCode);
    }

    @Override
    public String toString() {
         return country+"_"+code;
    }
}
