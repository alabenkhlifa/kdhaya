package tn.kdhaya.website.services;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Provider;
import tn.kdhaya.website.exceptions.ProviderNotFoundException;

import java.util.List;

public interface IProviderService {

    Provider save(Provider provider);

    List<Provider> saveAll(List<Provider> providerList);

    Provider findById(Long id) throws ProviderNotFoundException;

    boolean existsById(Long id);

    List<Provider> findAll();

    long count();

    void deleteById(Long id);

    void delete(Provider provider);

    void deleteAll(List<Provider> providerList);

    void deleteAll();
}
