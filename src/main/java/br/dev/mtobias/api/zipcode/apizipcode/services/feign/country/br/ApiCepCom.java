package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model.ApiCepComModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "apicepCom", url = "https://ws.apicep.com/cep/")
public interface ApiCepCom{
    @RequestMapping("{zipCode}.json")
    ApiCepComModel findZip(@PathVariable("zipCode") String zipCode);
}
