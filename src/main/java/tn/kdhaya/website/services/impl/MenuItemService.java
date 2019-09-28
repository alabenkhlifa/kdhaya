package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.MenuItem;
import tn.kdhaya.website.exceptions.MenuItemNotFoundException;
import tn.kdhaya.website.repositories.MenuItemRepository;
import tn.kdhaya.website.services.IMenuItemService;

import java.util.List;

@Service
public class MenuItemService implements IMenuItemService {

    private final MenuItemRepository repository;

    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MenuItem> getMenuItemsByMenu_Id(Long menuId) {
        return repository.getMenuItemsByMenu_Id(menuId);
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return repository.save(menuItem);
    }

    @Override
    public List<MenuItem> saveAll(List<MenuItem> menuItemList) {
        return (List<MenuItem>) repository.saveAll(menuItemList);
    }

    @Override
    public MenuItem findById(Long id) throws MenuItemNotFoundException {
        return repository.findById(id).orElseThrow(() -> new MenuItemNotFoundException(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<MenuItem> findAll() {
        return (List<MenuItem>) repository.findAll();
    }

    @Override
    public List<MenuItem> findAllById(List<Long> idList) {
        return (List<MenuItem>) repository.findAllById(idList);
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
    public void delete(MenuItem menuItem) {
        repository.delete(menuItem);
    }

    @Override
    public void deleteAll(List<MenuItem> menuItemList) {
        repository.deleteAll(menuItemList);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<MenuItem> findAllOrderedByPrice(Long menuId, String order) {
        if (order.toLowerCase().equals("asc"))
            return repository.getByMenu_IdOrderByPriceAsc(menuId);
        return repository.getByMenu_IdOrderByPriceDesc(menuId);
    }

    @Override
    public void deleteByMenuId(Long menuId) {
        repository.deleteByMenu_Id(menuId);
    }
}
