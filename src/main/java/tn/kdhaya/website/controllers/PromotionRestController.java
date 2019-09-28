package tn.kdhaya.website.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.entities.Promotion;
import tn.kdhaya.website.exceptions.PromotionNotFoundException;
import tn.kdhaya.website.services.IPromotionService;

@RestController
@RequestMapping("/api/promotion")
public class PromotionRestController {

    private final IPromotionService service;

    public PromotionRestController(IPromotionService service) {
        this.service = service;
    }

    @PostMapping("/{discount}")
    public Promotion saveOrUpdate(@PathVariable Long discount) {
        return service.save(discount);
    }

    @PostMapping("use/{id}")
    public void use(@PathVariable Long id) throws PromotionNotFoundException {
        service.usePromotion(id);
    }

    @GetMapping("/get/{id}")
    public Promotion getOneById(@PathVariable Long id) throws PromotionNotFoundException {
        return service.findById(id);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        service.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
