package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.pt.model.ApiDuminioComModel;
import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "apiDuminioCom", url = "https://api.duminio.com/ptcp/v2/ptapi61e20231d50d23.56405552/" )
public interface ApiDuminioCom{

    @RequestMapping("{zipCode}")
    Optional<List<ApiDuminioComModel>> findAllZip(@PathVariable("zipCode") String zipCode);
}
