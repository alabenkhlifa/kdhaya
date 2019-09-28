package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Provider;
import tn.kdhaya.website.exceptions.ProviderNotFoundException;
import tn.kdhaya.website.repositories.ProviderRepository;
import tn.kdhaya.website.services.IProviderService;

import java.util.List;

@Service
public class ProviderService implements IProviderService {

    private final ProviderRepository repository;

    public ProviderService(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Provider save(Provider provider) {
        return repository.save(provider);
    }

    @Override
    public List<Provider> saveAll(List<Provider> providerList) {
        return (List<Provider>) repository.saveAll(providerList);
    }

    @Override
    public Provider findById(Long id) throws ProviderNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ProviderNotFoundException(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Provider> findAll() {
        return (List<Provider>) repository.findAll();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Provider provider) {
        repository.delete(provider);
    }

    @Override
    public void deleteAll(List<Provider> providerList) {
        repository.deleteAll(providerList);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
