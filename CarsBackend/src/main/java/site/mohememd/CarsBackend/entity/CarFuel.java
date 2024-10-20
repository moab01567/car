package site.mohememd.CarsBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car_fuel")
@Setter @Getter

public class CarFuel {

    @Id @Column(name = "carFuelID")
    private Integer carFuelId;

    @Column(name = "FuelName")
    private String fuelName;
}
