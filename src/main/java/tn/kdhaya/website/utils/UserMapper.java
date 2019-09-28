package tn.kdhaya.website.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.kdhaya.website.dto.UserDTO;
import tn.kdhaya.website.entities.User;
import tn.kdhaya.website.services.IUserService;

@Component
public class UserMapper {

    private final IUserService userService;

    public UserMapper(IUserService userService) {
        this.userService = userService;
    }

    public static User getEntityFromDTO(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setActivated(dto.isActivated());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setSurname(dto.getSurname());
        user.setUsername(dto.getUsername());
        return user;
    }

    public static UserDTO getDTOFromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setActivated(user.isActivated());
        dto.setAge(user.getAge());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setPhone(user.getPhone());
        dto.setSurname(user.getSurname());
        dto.setUsername(user.getUsername());
        return dto;
    }
}
