package tn.kdhaya.website.services;

import tn.kdhaya.website.dto.UserDTO;
import tn.kdhaya.website.entities.User;
import tn.kdhaya.website.exceptions.UserNotFoundException;

import java.util.List;

public interface IUserService {

    UserDTO save(User user);

    List<UserDTO> saveAll(List<User> userList);

    UserDTO findById(Long id) throws UserNotFoundException;

    boolean existsById(Long id);

    List<UserDTO> findAll();

    long count();

    void deleteById(Long id);

    void delete(User user);

    void deleteAll(List<User> userList);

    void deleteAll();

}
