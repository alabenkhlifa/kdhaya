package tn.kdhaya.website.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("User")
public class User extends BaseUser {

    @Transient
    private int age;

    @Builder
    public User(Long id, boolean activated, String passwordResetToken, String name, String surname, String username, String password, String email, String phone, int age) {
        super(id, activated, passwordResetToken, name, surname, username, password, email, phone);
        this.age = age;
    }
}
