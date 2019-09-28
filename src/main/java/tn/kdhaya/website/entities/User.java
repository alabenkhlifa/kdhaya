package tn.kdhaya.website.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("User")
public class User extends BaseUser {

    @Transient
    private int age;


}
