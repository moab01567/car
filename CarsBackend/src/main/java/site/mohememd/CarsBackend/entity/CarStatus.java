package site.mohememd.CarsBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "car_status")
@Setter @Getter
public class CarStatus {

    @Id @Column(name = "carStatusID")
    private Integer carStatusId;

    @Column(name = "statusType")
    private String statusType;

    @OneToMany(mappedBy = "carStatus")
    private List<Car> cars;
}
