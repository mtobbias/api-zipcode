package br.dev.mtobias.api.zipcode.apizipcode.enums;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

 class CountryEnumTest {

    @Test
    void should_be_return_br_when_create_enum_BR(){
        CountryEnum br = CountryEnum.BRAZIL;
        assertThat(br).isNotNull();
        assertThat(br.getCountry()).isEqualTo("br");
    }


    @Test
    void should_be_return_pt_when_create_enum_PT(){
        CountryEnum br = CountryEnum.PORTUGAL;
        assertThat(br).isNotNull();
        assertThat(br.getCountry()).isEqualTo("pt");
    }

     @Test
     void should_be_return_pt_when_create_enum_PT2(){
         assertThat(CountryEnum.BRAZIL.getCountry()).isEqualTo("br");
     }
}
