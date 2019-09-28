package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Steed;
import tn.kdhaya.website.exceptions.ShoreNotFoundException;
import tn.kdhaya.website.exceptions.SteedNotFoundException;
import tn.kdhaya.website.repositories.SteedRepository;
import tn.kdhaya.website.services.ISteedService;

import java.util.List;

@Service
public class SteedService implements ISteedService {

    private SteedRepository repository;

    public SteedService(SteedRepository repository) {
        this.repository = repository;
    }

    @Override
    public Steed save(Steed steed) {
        return repository.save(steed);
    }

    @Override
    public Steed findById(Long id) throws SteedNotFoundException {
        return repository.findById(id).orElseThrow(() -> new SteedNotFoundException(id));
    }

    @Override
    public List<Steed> findAll() {
        return (List<Steed>) repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
