package tn.kdhaya.website.services;

import tn.kdhaya.website.entities.Menu;
import tn.kdhaya.website.entities.User;
import tn.kdhaya.website.exceptions.MenuNotFoundException;
import tn.kdhaya.website.exceptions.UserNotFoundException;

import java.util.List;

public interface IUserService {

    User save(User user);

    List<User> saveAll(List<User> userList);

    User findById(Long id) throws UserNotFoundException;

    boolean existsById(Long id);

    List<User> findAll();

    long count();

    void deleteById(Long id);

    void delete(User user);

    void deleteAll(List<User> userList);

    void deleteAll();

}
