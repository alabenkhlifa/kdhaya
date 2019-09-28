package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.Promotion;
import tn.kdhaya.website.exceptions.PromotionNotFoundException;
import tn.kdhaya.website.repositories.PromotionRepository;
import tn.kdhaya.website.services.IPromotionService;

import java.util.Date;
import java.util.List;

@Service
public class PromotionService implements IPromotionService {

    private final PromotionRepository repository;

    public PromotionService(PromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Promotion getPromotionByCodeEquals(String code) {
        return null;
    }

    @Override
    public Promotion save(Long discount) {
        Promotion promotion = new Promotion();
        // TODO: 9/26/2019 RANDOM CODE
        promotion.setCode("");
        promotion.setDiscountAmount(discount);
        return repository.save(promotion);
    }

    @Override
    public List<Promotion> saveAll(List<Promotion> promotionList) {
        return (List<Promotion>) repository.saveAll(promotionList);
    }

    @Override
    public Promotion findById(Long id) throws PromotionNotFoundException {
        return repository.findById(id).orElseThrow(() -> new PromotionNotFoundException(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Promotion> findAll() {
        return (List<Promotion>) repository.findAll();
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
    public void delete(Promotion promotion) {
        repository.delete(promotion);
    }

    @Override
    public void deleteAll(List<Promotion> promotionList) {
        repository.deleteAll(promotionList);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void usePromotion(Long id) throws PromotionNotFoundException {
        Promotion promotion = findById(id);
        promotion.setUsed(true);
        promotion.setUsageDate(new Date());

        repository.save(promotion);
    }

}
