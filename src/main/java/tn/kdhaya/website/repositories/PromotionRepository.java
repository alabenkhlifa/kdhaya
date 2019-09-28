package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.kdhaya.website.entities.Promotion;

public interface PromotionRepository extends CrudRepository<Promotion, Long> {
    Promotion getPromotionByCodeEquals(String code);
}
