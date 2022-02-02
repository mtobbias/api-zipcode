package br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.mapper.ZipCodeMapper;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.ServiceCountry;
import br.dev.mtobias.api.zipcode.apizipcode.services.feign.country.br.model.ApiCepComModel;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceCountryBR implements ServiceCountry {

    private final ApiCepCom service;
    private final ZipCodeMapper mapper;

    @Override
    public ZipCodeDTO findZip(String zipCode) {
        Optional<ApiCepComModel> zip = service.findZip(zipCode);
        ApiCepComModel zipModel = validateZipCode(zip);

        return mapper.fromModel(zipModel);
    }

    private ApiCepComModel validateZipCode(Optional<ApiCepComModel> zip) {
        ApiCepComModel zipModel = zip.orElseThrow(() -> new IllegalArgumentException("cep não encontado"));
        if(Objects.isNull(zipModel.getCode())  || zipModel.getCode().isEmpty() || zipModel.getCode().isBlank()){
            throw new IllegalArgumentException("cep não encontado");
        }
        return zipModel;
    }

}
