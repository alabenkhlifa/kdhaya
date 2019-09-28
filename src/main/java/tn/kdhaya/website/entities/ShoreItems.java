package tn.kdhaya.website.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoreItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Shore shore;

    @ManyToOne
    @JsonIgnore
    private MenuItem menuItem;

    private int quantity;

    @Override
    public String toString() {
        return "ShoreItems : {" +
                "id=" + id +
                ", menuItem=" + menuItem +
                ", quantity=" + quantity +
                '}';
    }
}
