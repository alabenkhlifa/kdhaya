package tn.kdhaya.website.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "menu_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String category;
    @Lob
    private Byte[] image;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Menu.class)
    private Menu menu;
//    @OneToMany(mappedBy = "menuItem")
//    private List<ShoreItems> shores = new ArrayList<>();
}
