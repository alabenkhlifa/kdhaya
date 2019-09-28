package tn.kdhaya.website.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.entities.Provider;
import tn.kdhaya.website.exceptions.ProviderNotFoundException;
import tn.kdhaya.website.services.IProviderService;

import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class ProviderRestController {

    private final IProviderService service;

    public ProviderRestController(IProviderService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Provider> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Provider getOneById(@PathVariable Long id) throws ProviderNotFoundException {
        return service.findById(id);
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    public Provider saveOrUpdate(Provider provider) {
        return service.save(provider);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOne(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/increase-popularity/{id}")
    public void increasePopularity(@PathVariable Long id) throws ProviderNotFoundException {
        Provider provider = service.findById(id);
        provider.increasePopularity();
        service.save(provider);
    }

}
