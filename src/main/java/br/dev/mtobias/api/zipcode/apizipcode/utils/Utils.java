package br.dev.mtobias.api.zipcode.apizipcode.utils;

public final class Utils {

    private Utils() {
    }

    public static String generateIdZipCodeRedis(String country, String zipCode){
        return country+'_'+removeNoNumbers(zipCode);
    }

    public static String removeNoNumbers(String value){
        return value.replaceAll("[^\\d.]","");
    }
}
