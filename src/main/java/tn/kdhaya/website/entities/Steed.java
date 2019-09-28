package tn.kdhaya.website.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.kdhaya.website.enums.SteedShift;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Steed")
public class Steed extends BaseUser {
    private String steedId;
    private SteedShift shift;
}
