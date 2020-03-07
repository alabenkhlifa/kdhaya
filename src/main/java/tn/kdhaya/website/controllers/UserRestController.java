package tn.kdhaya.website.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.kdhaya.website.dto.UserDTO;
import tn.kdhaya.website.entities.User;
import tn.kdhaya.website.exceptions.UserNotFoundException;
import tn.kdhaya.website.services.IUserService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserRestController {

    private IUserService userService;

    public UserRestController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserDTO> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getOneById(@PathVariable Long id) throws UserNotFoundException {
        return userService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(User user) {
        return userService.save(user);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeOneById(@PathVariable Long id) {
        userService.deleteById(id);
    }


}
