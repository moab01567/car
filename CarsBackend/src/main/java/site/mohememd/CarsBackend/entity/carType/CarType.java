package site.mohememd.CarsBackend.entity.carType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import site.mohememd.CarsBackend.entity.car.Car;

import java.util.List;

@Entity
@Table(name = "car_type")
@Setter @Getter
public class CarType {

    @Id @Column(name = "carTypeID")
    private Integer carTypeId;

    @Column(name = "carModel")
    private String carModel;

    @OneToMany(mappedBy = "carType")
    private List<Car> cars;

}
