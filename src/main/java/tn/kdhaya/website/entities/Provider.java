package tn.kdhaya.website.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String owner;
    @Temporal(TemporalType.DATE)
    private Date creationDate = new Date();
    @Lob
    private Byte[] image;
    private Long popularity;
//    @OneToOne(mappedBy = "provider")
//    private Menu menu;

    public void increasePopularity() {
        this.popularity++;
    }
}
