package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.kdhaya.website.entities.MenuItem;

import java.util.List;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

    List<MenuItem> getMenuItemsByMenu_Id(Long menuId);

    List<MenuItem> getByMenu_IdOrderByPriceAsc(Long menuId);

    List<MenuItem> getByMenu_IdOrderByPriceDesc(Long menuId);

    void deleteByMenu_Id(Long menuId);

}
