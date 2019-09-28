package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.User;
import tn.kdhaya.website.exceptions.UserNotFoundException;
import tn.kdhaya.website.repositories.UserRepository;
import tn.kdhaya.website.services.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> saveAll(List<User> userList) {
        return (List<User>) repository.saveAll(userList);
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void deleteAll(List<User> userList) {
        repository.deleteAll(userList);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
