package br.dev.mtobias.api.zipcode.apizipcode.redis.repository;

import br.dev.mtobias.api.zipcode.apizipcode.redis.model.ZipCodeModel;
import org.springframework.data.repository.CrudRepository;

public interface ZipCodeRepository extends CrudRepository<ZipCodeModel, String> {
}
