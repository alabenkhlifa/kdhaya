package tn.kdhaya.website.utils;

import org.springframework.stereotype.Component;
import tn.kdhaya.website.dto.UserDTO;
import tn.kdhaya.website.entities.User;

@Component
public class UserMapper {

    private UserMapper() {
    }

    public static User getEntityFromDTO(UserDTO dto) {
        return User
                .builder()
                .id(dto.getId())
                .activated(dto.isActivated())
                .age(dto.getAge())
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .surname(dto.getSurname())
                .username(dto.getUsername())
                .build();
    }

    public static UserDTO getDTOFromEntity(User user) {
        return UserDTO
                .builder()
                .id(user.getId())
                .activated(user.isActivated())
                .age(user.getAge())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .phone(user.getPhone())
                .surname(user.getSurname())
                .username(user.getUsername())
                .build();
    }
}
