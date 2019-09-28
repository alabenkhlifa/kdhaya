package tn.kdhaya.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.kdhaya.website.entities.BaseUser;
import tn.kdhaya.website.entities.User;
import tn.kdhaya.website.exceptions.BaseUserNotFoundException;
import tn.kdhaya.website.exceptions.UserNotFoundException;
import tn.kdhaya.website.repositories.BaseUserRepository;

@RestController
@RequestMapping("/api/base-user")
public class BaseUserRestController {

    private final BaseUserRepository repository;

    public BaseUserRestController(BaseUserRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/disactivate/{id}")
    public void disactivate(@PathVariable Long id) throws BaseUserNotFoundException {
        BaseUser baseUser = repository.findById(id).orElseThrow(() -> new BaseUserNotFoundException(id));
        baseUser.setActivated(false);
        repository.save(baseUser);
    }

    @PutMapping("/activate/{id}")
    public void activate(@PathVariable Long id) throws BaseUserNotFoundException {
        BaseUser baseUser = repository.findById(id).orElseThrow(() -> new BaseUserNotFoundException(id));
        baseUser.setActivated(true);
        repository.save(baseUser);
    }

    @PutMapping("/change-password/{id}")
    public void changePassword(@PathVariable Long id, String password) throws BaseUserNotFoundException {
        BaseUser baseUser = repository.findById(id).orElseThrow(() -> new BaseUserNotFoundException(id));
        baseUser.setPassword(password);
        repository.save(baseUser);
    }

    // TODO: Reset Password
    @PutMapping("/reset-password/{id}")
    public void resetPassword(@PathVariable Long id) throws BaseUserNotFoundException {
        BaseUser baseUser = repository.findById(id).orElseThrow(() -> new BaseUserNotFoundException(id));
        baseUser.setPasswordResetToken("");
        // send Email
    }
}
