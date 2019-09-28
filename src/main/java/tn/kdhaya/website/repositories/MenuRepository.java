package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.kdhaya.website.entities.Menu;

import java.util.List;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {
    List<Menu> getMenusByIdIsNotNullOrderByIdDesc();

    Menu getByProvider_Id(Long providerId);

    List<Menu> getByCreationDateNotNullOrderByProvider_IdDesc();
}
