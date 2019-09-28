package tn.kdhaya.website.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.entities.*;
import tn.kdhaya.website.enums.ShoreStatus;
import tn.kdhaya.website.exceptions.NoPermissionException;
import tn.kdhaya.website.exceptions.ShoreNotFoundException;
import tn.kdhaya.website.services.IShoreService;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("api/shore")
public class ShoreRestController {

    private IShoreService shoreService;

    public ShoreRestController(IShoreService shoreService) {
        this.shoreService = shoreService;
    }

    @GetMapping("/{id}")
    public Shore getOneById(@PathVariable Long id) throws ShoreNotFoundException {
        return shoreService.findById(id);
    }

    @GetMapping("/")
    public List<Shore> getAll() {
        return shoreService.findAll();
    }

    // TODO: 9/23/2019 filter between 2 dates
    // Note : Format of date should be yyyy/mm/dd
    @GetMapping("/between/{startDate}/{endDate}")
    public List<Shore> getAllBetweenTwoDates(@PathVariable String startDate, @PathVariable String endDate) {
        Date startingDate = new Date();
        startingDate.setYear(Integer.parseInt(startDate.substring(0, 4)));
        startingDate.setMonth(Integer.parseInt(startDate.substring(6, 7)) - 1);
        startingDate.setDate(Integer.parseInt(startDate.substring(8, 10)));

        Date endingDate = new Date();
        endingDate.setYear(Integer.parseInt(endDate.substring(0, 4)));
        endingDate.setMonth(Integer.parseInt(endDate.substring(6, 7)) - 1);
        endingDate.setDate(Integer.parseInt(endDate.substring(8, 10)));
        List<Shore> byCreationDateBetween = shoreService.findByCreationDateBetween(startingDate, endingDate);
        return shoreService.findByCreationDateBetween(startingDate, endingDate);
    }

    @GetMapping("filter/status/{status}")
    public List<Shore> getAllWithStatus(@PathVariable String status) {
        if (Arrays.stream(ShoreStatus.values()).anyMatch((value) -> status.toLowerCase().equalsIgnoreCase(value.toString().toLowerCase())))
            return shoreService.findAllByStatus(ShoreStatus.valueOf(status));
        return Collections.emptyList();
    }

    @PostMapping("/cancel/{shoreId}")
    @ResponseStatus(HttpStatus.OK)
    public void cancelShore(@PathVariable Long shoreId, BaseUser connectedUser) throws ShoreNotFoundException, NoPermissionException {
        Shore shore = shoreService.findById(shoreId);
        if (canCancel(shore, connectedUser))
            shoreService.cancel(shoreId);
        else
            throw new NoPermissionException("cancel the shore");
    }

    private boolean canCancel(Shore shore, BaseUser connectedUser) {
        return connectedUser instanceof Dispatcher
                || connectedUser instanceof Steed
                || connectedUser.getId().equals(shore.getCreator().getId());
    }
}
