package tn.kdhaya.website.services;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.MenuItem;
import tn.kdhaya.website.exceptions.MenuItemNotFoundException;

import java.util.List;

public interface IMenuItemService {

    List<MenuItem> getMenuItemsByMenu_Id(Long menuId);

    MenuItem save(MenuItem menuItem);

    List<MenuItem> saveAll(List<MenuItem> menuItemList);

    MenuItem findById(Long id) throws MenuItemNotFoundException;

    boolean existsById(Long id);

    List<MenuItem> findAll();

    List<MenuItem> findAllById(List<Long> idList);

    long count();

    void deleteById(Long id);

    void delete(MenuItem menuItem);

    void deleteAll(List<MenuItem> menuItemList);

    void deleteAll();

    List<MenuItem> findAllOrderedByPrice(Long menuId, String order);

    void deleteByMenuId(Long menuId);
}
