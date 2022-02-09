package br.dev.mtobias.api.zipcode.apizipcode.enums;

public enum CountryEnum {
    BRAZIL("BR"),
    PORTUGAL("PT");

    private String country;
    CountryEnum(String country) {
        this.country= country;
    }
    public String getCountry() {
        return this.country.toLowerCase();
    }
}
