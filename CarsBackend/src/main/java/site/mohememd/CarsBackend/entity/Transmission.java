package site.mohememd.CarsBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "transmission")
@Setter @Getter
public class Transmission {

    @Id @Column(name = "transmissionID")
    private Integer transmissionId;

    @Column(name = "transmissionType")
    private String transmissionType;

    @OneToMany(mappedBy = "transmission")
    private List<Car> cars;
}
