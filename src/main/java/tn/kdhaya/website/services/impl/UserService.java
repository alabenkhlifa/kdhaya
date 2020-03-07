package tn.kdhaya.website.services.impl;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.dto.UserDTO;
import tn.kdhaya.website.entities.User;
import tn.kdhaya.website.exceptions.UserNotFoundException;
import tn.kdhaya.website.repositories.UserRepository;
import tn.kdhaya.website.services.IUserService;
import tn.kdhaya.website.utils.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO save(User user) {
        return UserMapper.getDTOFromEntity(repository.save(user));
    }

    @Override
    public List<UserDTO> saveAll(List<User> userList) {
        List<User> users = (List<User>) repository.saveAll(userList);
        return users.stream().map(UserMapper::getDTOFromEntity).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) throws UserNotFoundException {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.getDTOFromEntity(user);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = (List<User>) repository.findAll();
        return users.stream().map(UserMapper::getDTOFromEntity).collect(Collectors.toList());
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
