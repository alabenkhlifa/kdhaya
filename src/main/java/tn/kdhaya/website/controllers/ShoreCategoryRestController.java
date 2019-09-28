package tn.kdhaya.website.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.entities.MenuItem;
import tn.kdhaya.website.entities.ShoreCategory;
import tn.kdhaya.website.services.IShoreCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/shore-category")
public class ShoreCategoryRestController {

    private final IShoreCategoryService service;

    public ShoreCategoryRestController(IShoreCategoryService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<ShoreCategory> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    public ShoreCategory saveOrUpdate(ShoreCategory shoreCategory) {
        return service.save(shoreCategory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
