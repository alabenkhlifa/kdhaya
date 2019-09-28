package tn.kdhaya.website.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.entities.User;
import tn.kdhaya.website.exceptions.UserNotFoundException;
import tn.kdhaya.website.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private IUserService userService;

    public UserRestController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getOneById(@PathVariable Long id) throws UserNotFoundException {
        return userService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(User user) {
        userService.save(user);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(User user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeOneById(@PathVariable Long id) {
        userService.deleteById(id);
    }


}
