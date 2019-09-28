package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Menu;
import tn.kdhaya.website.exceptions.MenuNotFoundException;
import tn.kdhaya.website.repositories.MenuRepository;
import tn.kdhaya.website.services.IMenuService;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public Menu save(Menu menu) {
        return repository.save(menu);
    }

    @Override
    public List<Menu> saveAll(List<Menu> menuList) {
        return (List<Menu>) repository.saveAll(menuList);
    }

    @Override
    public Menu findById(Long id) throws MenuNotFoundException {
        return repository.findById(id).orElseThrow(() -> new MenuNotFoundException(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Menu> findAll() {
        return (List<Menu>) repository.findAll();
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
    public void delete(Menu menu) {
        repository.delete(menu);
    }

    @Override
    public void deleteAll(List<Menu> menuList) {
        repository.deleteAll(menuList);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Menu getByProviderId(Long providerId) {
        return repository.getByProvider_Id(providerId);
    }

    @Override
    public List<Menu> findAllOrderByProviderPopularity() {
        return repository.getByCreationDateNotNullOrderByProvider_IdDesc();
    }
}
