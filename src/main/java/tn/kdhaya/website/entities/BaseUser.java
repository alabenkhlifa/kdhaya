package tn.kdhaya.website.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean activated = true;
    private String passwordResetToken;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String phone;

    public void setPassword(String password) {
        this.password = password;
        this.passwordResetToken = null;
    }

}
