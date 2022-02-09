package br.dev.mtobias.api.zipcode.apizipcode.utils;

public class Utils {

    public static String generateIdZipCodeRedis(String country, String zipCode){
        return country+'_'+zipCode.replaceAll("[^\\d.]","");
    }
}
