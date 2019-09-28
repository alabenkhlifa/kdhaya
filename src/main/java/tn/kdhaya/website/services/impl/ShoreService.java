package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Menu;
import tn.kdhaya.website.entities.MenuItem;
import tn.kdhaya.website.entities.Shore;
import tn.kdhaya.website.entities.ShoreItems;
import tn.kdhaya.website.enums.ShoreStatus;
import tn.kdhaya.website.exceptions.ShoreNotFoundException;
import tn.kdhaya.website.exceptions.SteedNotFoundException;
import tn.kdhaya.website.repositories.ShoreRepository;
import tn.kdhaya.website.services.IProviderService;
import tn.kdhaya.website.services.IShoreService;
import tn.kdhaya.website.services.ISteedService;

import java.util.Date;
import java.util.List;

@Service
public class ShoreService implements IShoreService {

    private final ShoreRepository repository;
    private ISteedService steedService;
    private IProviderService providerService;

    public ShoreService(ShoreRepository repository, ISteedService steedService, IProviderService providerService) {
        this.repository = repository;
        this.steedService = steedService;
        this.providerService = providerService;
    }

    // Before saving , check if the shore contains menuItems, if it does, increment the provider popularity by +1
    @Override
    public Shore save(Shore shore) {
        if (shore.getMenuItems() != null) {
            shore.getMenuItems()
                    .stream()
                    .map(ShoreItems::getMenuItem)
                    .map(MenuItem::getMenu)
                    .map(Menu::getProvider)
                    .distinct()
                    .forEach(provider -> {
                                provider.setPopularity(provider.getPopularity() + 1);
                                providerService.save(provider);
                            }
                    );
        }
        return repository.save(shore);
    }

    @Override
    public List<Shore> saveAll(List<Shore> shoreList) {
        return (List<Shore>) repository.saveAll(shoreList);
    }

    @Override
    public Shore findById(Long id) throws ShoreNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ShoreNotFoundException(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Shore> findAll() {
        return (List<Shore>) repository.findAll();
    }

    @Override
    public List<Shore> findAllByStatus(ShoreStatus shoreStatus) {
        return repository.findByStatusEquals(shoreStatus);
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
    public void delete(Shore shore) {
        repository.delete(shore);
    }

    @Override
    public void deleteAll(List<Shore> shoreList) {
        repository.deleteAll();
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public void cancel(Long id) throws ShoreNotFoundException {
        Shore shore = findById(id);
        shore.setStatus(ShoreStatus.Cancelled);
        save(shore);
    }

    @Override
    public void takeCharge(Long shoreId, Long steedId) throws ShoreNotFoundException, SteedNotFoundException {
        Shore shore = findById(shoreId);
        shore.setStatus(ShoreStatus.InProgress);
        shore.setSteed(steedService.findById(steedId));
        repository.save(shore);
    }

    @Override
    public List<Shore> findByCreationDateBetween(Date startDate, Date endDate) {
        return repository.findAllByCreationDateIsBetween(startDate, endDate);
    }


}
