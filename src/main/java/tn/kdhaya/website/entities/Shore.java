package tn.kdhaya.website.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tn.kdhaya.website.enums.ShoreStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shore {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date creationDate;
    @ManyToOne
    private BaseUser creator;
    @Enumerated(EnumType.STRING)
    private ShoreStatus status = ShoreStatus.Waiting;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @ManyToOne
    private ShoreCategory category;
    @ManyToOne
    private Steed steed;
    @Column(length = 1000)
    private String description;
    private String fromLocation;
    private String toLocation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date inChargeAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishedAt;
    private String userAgent;
    private int satisfaction;
    private Double cost;
    @ManyToOne
    private Dispatcher dispatcher;
    @OneToMany(mappedBy = "shore", cascade = CascadeType.PERSIST)
    private List<ShoreItems> menuItems = new ArrayList<>();

    public void setStatus(ShoreStatus status) {
        this.status = status;
        if (status == ShoreStatus.InProgress)
            this.setInChargeAt(new Date());
        if (status == ShoreStatus.Finished)
            this.setFinishedAt(new Date());
        if (status == ShoreStatus.Cancelled)
            this.setCancelDate(new Date());
    }

    public void addMenuItem(ShoreItems item) {
        menuItems.add(item);
    }

}
