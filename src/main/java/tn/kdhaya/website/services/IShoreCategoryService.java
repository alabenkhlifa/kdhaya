package tn.kdhaya.website.services;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.ShoreCategory;
import tn.kdhaya.website.exceptions.ShoreCategoryNotFoundException;

import java.util.List;

public interface IShoreCategoryService {

    ShoreCategory save(ShoreCategory shoreCategory);

    List<ShoreCategory> saveAll(List<ShoreCategory> shoreCategoryList);

    ShoreCategory findById(Long id) throws ShoreCategoryNotFoundException;

    boolean existsById(Long id);

    List<ShoreCategory> findAll();

    long count();

    void deleteById(Long id);

    void delete(ShoreCategory shoreCategory);

    void deleteAll(List<ShoreCategory> shoreCategoryList);

    void deleteAll();
}
