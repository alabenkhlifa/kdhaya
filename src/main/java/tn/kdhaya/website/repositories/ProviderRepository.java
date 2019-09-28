package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.kdhaya.website.entities.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
