package tn.kdhaya.website.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private boolean activated = true;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int age;

}
