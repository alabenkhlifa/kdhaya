package tn.kdhaya.website.controllers;

import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.entities.MenuItem;
import tn.kdhaya.website.exceptions.MenuItemNotFoundException;
import tn.kdhaya.website.exceptions.MenuNotFoundException;
import tn.kdhaya.website.services.IMenuItemService;
import tn.kdhaya.website.services.IMenuService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/item-menu")
public class MenuItemRestController {

    private final IMenuItemService service;
    private final IMenuService menuService;

    public MenuItemRestController(IMenuItemService service, IMenuService menuService) {
        this.service = service;
        this.menuService = menuService;
    }

    @GetMapping("/")
    public List<MenuItem> getAll() {
        return service.findAll();
    }

    @GetMapping("/menu/{menuId}")
    public List<MenuItem> getByMenuId(Long menuId) {
        return service.getMenuItemsByMenu_Id(menuId);
    }

    @GetMapping("{menuId}/group-by-category")
    public HashMap<String, List<MenuItem>> getAllGroupedByCategory(@PathVariable Long menuId) throws MenuNotFoundException {
        if (!menuService.existsById(menuId))
            throw new MenuNotFoundException(menuId);
        List<MenuItem> menuItemList = service.getMenuItemsByMenu_Id(menuId);
        HashMap<String, List<MenuItem>> hashMap = new HashMap<>();
        menuItemList
                .forEach(menuItem ->
                        hashMap.computeIfAbsent(menuItem.getCategory(), k -> new ArrayList<>()).add(menuItem)
                );
        return hashMap;
    }

    @GetMapping("{menuId}/orderByPrice/{order}")
    public List<MenuItem> getAllOrderedByPrice(@PathVariable String order, @PathVariable Long menuId) {
        if (!order.toLowerCase().equals("asc"))
            order = "desc";
        return service.findAllOrderedByPrice(menuId, order);
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    public MenuItem save(MenuItem menuItem) {
        return service.save(menuItem);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteAll() {
        service.deleteAll();
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneById(@PathVariable Long id) throws MenuItemNotFoundException {
        if (!service.existsById(id))
            throw new MenuItemNotFoundException(id);
        service.deleteById(id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/menu/{menuId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByMenuId(@PathVariable Long menuId) {
        service.deleteByMenuId(menuId);
    }
}
