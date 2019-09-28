package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.SteedPosition;
import tn.kdhaya.website.repositories.SteedPositionRepository;
import tn.kdhaya.website.services.ISteedPositionService;

@Service
public class SteedPositionService implements ISteedPositionService {

    private final SteedPositionRepository repository;

    public SteedPositionService(SteedPositionRepository repository) {
        this.repository = repository;
    }

    @Override
    public SteedPosition get() {
        return repository.findFirstByIdNotNull();
    }

    @Override
    public SteedPosition save(SteedPosition steedPosition) {
        return repository.save(steedPosition);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
