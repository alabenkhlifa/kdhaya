package tn.kdhaya.website.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
