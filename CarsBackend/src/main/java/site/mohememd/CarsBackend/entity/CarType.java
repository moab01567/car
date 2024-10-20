package site.mohememd.CarsBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car_type")
@Setter @Getter
public class CarType {

    @Id @Column(name = "carTypeID")
    private Integer carTypeId;

    @Column(name = "carModel")
    private String carModel;
}
