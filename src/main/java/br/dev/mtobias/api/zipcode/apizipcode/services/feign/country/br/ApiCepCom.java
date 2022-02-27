package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model.ApiCepComModel;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "apicepCom", url = "${feignApi.apicepCom.url}")
public interface ApiCepCom{
    @RequestMapping("{zipCode}${feignApi.apicepCom.postfix}")
    Optional<ApiCepComModel> findZip(@PathVariable("zipCode") String zipCode);
}