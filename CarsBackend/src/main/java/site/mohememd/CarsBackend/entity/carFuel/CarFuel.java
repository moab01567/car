package site.mohememd.CarsBackend.entity.carFuel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import site.mohememd.CarsBackend.entity.car.Car;

import java.util.List;

@Entity
@Table(name = "car_fuel")
@Setter @Getter
public class CarFuel {

    @Id @Column(name = "carFuelID")
    private Integer carFuelId;

    @Column(name = "FuelName")
    private String fuelName;

    @OneToMany(mappedBy = "carFuel")
    private List<Car> cars;

}
