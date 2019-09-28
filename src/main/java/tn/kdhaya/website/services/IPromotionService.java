package tn.kdhaya.website.services;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Promotion;
import tn.kdhaya.website.exceptions.PromotionNotFoundException;

import java.util.List;

public interface IPromotionService {

    Promotion getPromotionByCodeEquals(String code);

    Promotion save(Long discount);

    List<Promotion> saveAll(List<Promotion> promotionList);

    Promotion findById(Long id) throws PromotionNotFoundException;

    boolean existsById(Long id);

    List<Promotion> findAll();

    long count();

    void deleteById(Long id);

    void delete(Promotion promotion);

    void deleteAll(List<Promotion> promotionList);

    void deleteAll();

    void usePromotion(Long id) throws PromotionNotFoundException;
}
