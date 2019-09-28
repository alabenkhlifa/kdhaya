package tn.kdhaya.website.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Provider;
import tn.kdhaya.website.entities.ShoreCategory;
import tn.kdhaya.website.exceptions.ProviderNotFoundException;
import tn.kdhaya.website.exceptions.ShoreCategoryNotFoundException;
import tn.kdhaya.website.repositories.ShoreCategoryRepository;
import tn.kdhaya.website.services.IShoreCategoryService;

import java.util.List;

@Service
public class ShoreCategoryService implements IShoreCategoryService {

    private final ShoreCategoryRepository repository;

    public ShoreCategoryService(ShoreCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoreCategory save(ShoreCategory shoreCategory) {
        return repository.save(shoreCategory);
    }

    @Override
    public List<ShoreCategory> saveAll(List<ShoreCategory> shoreCategoryList) {
        return (List<ShoreCategory>) repository.saveAll(shoreCategoryList);
    }

    @Override
    public ShoreCategory findById(Long id) throws ShoreCategoryNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ShoreCategoryNotFoundException(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<ShoreCategory> findAll() {
        return (List<ShoreCategory>) repository.findAll();
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
    public void delete(ShoreCategory shoreCategory) {
        repository.delete(shoreCategory);
    }

    @Override
    public void deleteAll(List<ShoreCategory> shoreCategoryList) {
        repository.deleteAll(shoreCategoryList);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
