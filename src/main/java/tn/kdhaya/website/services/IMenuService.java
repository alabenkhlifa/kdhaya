package tn.kdhaya.website.services;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Menu;
import tn.kdhaya.website.exceptions.MenuNotFoundException;

import java.util.List;

public interface IMenuService {

    Menu save(Menu menu);

    List<Menu> saveAll(List<Menu> menuList);

    Menu findById(Long id) throws MenuNotFoundException;

    boolean existsById(Long id);

    List<Menu> findAll();

    long count();

    void deleteById(Long id);

    void delete(Menu menu);

    void deleteAll(List<Menu> menuList);

    void deleteAll();

    Menu getByProviderId(Long providerId);

    List<Menu> findAllOrderByProviderPopularity();
}
