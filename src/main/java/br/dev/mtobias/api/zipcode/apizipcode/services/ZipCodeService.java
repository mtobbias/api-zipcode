package br.dev.mtobias.api.zipcode.apizipcode.services;

import br.dev.mtobias.api.zipcode.apizipcode.exceptions.NotFoundException;
import br.dev.mtobias.api.zipcode.apizipcode.mapper.ZipCodeMapper;
import br.dev.mtobias.api.zipcode.apizipcode.redis.model.ZipCodeModel;
import br.dev.mtobias.api.zipcode.apizipcode.redis.repository.ZipCodeRepository;
import br.dev.mtobias.api.zipcode.apizipcode.rest.dto.ZipCodeDTO;
import br.dev.mtobias.api.zipcode.apizipcode.services.factory.FactoryServiceApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ZipCodeService {

    private final FactoryServiceApi factoryServiceApi;
    private final ZipCodeRepository repository;
    private final ZipCodeMapper mapper;

    public ZipCodeDTO findZipCodeByCountry(ZipCodeDTO zipCodeDTO) {
        validate(zipCodeDTO);
        ZipCodeDTO zipCodeDTOReturn = findInRepository(zipCodeDTO).orElse(findInService(zipCodeDTO));
        if(Objects.isNull(zipCodeDTOReturn.getPostalCode())){
            throw new NotFoundException("codeZipNotFound");
        }
        saveRepository(zipCodeDTOReturn);
        return zipCodeDTOReturn;
    }

    private void saveRepository(ZipCodeDTO zipCodeDTO) {
        repository.save(mapper.modelToDTO(zipCodeDTO));
    }

    private ZipCodeDTO findInService(ZipCodeDTO zipCodeDTO) {
        return factoryServiceApi.findZipCodeByCountry(zipCodeDTO).orElseThrow(()-> new NotFoundException("codeZipNotFound"));
    }
    private Optional<ZipCodeDTO> findInRepository(ZipCodeDTO zipCodeDTO) {
        Optional<ZipCodeModel> zipCodeOptional = repository.findById(ZipCodeModel.createId(zipCodeDTO.getCountry(), zipCodeDTO.getPostalCode()));
        return zipCodeOptional.isPresent()? Optional.of(mapper.dtoToModel(zipCodeOptional.get())) : Optional.empty();
    }

    private void validate(ZipCodeDTO zipCodeDTO) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ZipCodeDTO>> violations = validator.validate(zipCodeDTO);
        if (!violations.isEmpty()) {
            List<String> collect = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new IllegalArgumentException(String.format("errors %s", collect.toString()));
        }
    }
}
