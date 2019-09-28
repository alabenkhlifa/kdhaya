package tn.kdhaya.website.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.entities.SteedPosition;
import tn.kdhaya.website.services.ISteedPositionService;

@RestController
@RequestMapping("/api/steed-position")
public class SteedPositionRestController {

    private final ISteedPositionService service;

    public SteedPositionRestController(ISteedPositionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public SteedPosition getPosition() {
        return service.get();
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    public SteedPosition saveOrUpdate(SteedPosition steedPosition) {
        return service.save(steedPosition);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void deletePosition() {
        service.deleteAll();
    }
}
