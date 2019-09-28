package tn.kdhaya.website.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.entities.Menu;
import tn.kdhaya.website.exceptions.MenuNotFoundException;
import tn.kdhaya.website.services.IMenuService;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuRestController {

    private final IMenuService service;

    public MenuRestController(IMenuService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Menu> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Menu getOne(Long id) throws MenuNotFoundException {
        return service.findById(id);
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrUpdate(Menu menu) {
        service.save(menu);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        service.deleteAll();
    }

    @GetMapping("/getByProvider/{providerId}")
    public Menu getByProviderId(Long providerId) {
        return service.getByProviderId(providerId);
    }

    @GetMapping("/getAllOrderByProviderPopularity")
    public List<Menu> getByProviderId() {
        return service.findAllOrderByProviderPopularity();
    }
}
