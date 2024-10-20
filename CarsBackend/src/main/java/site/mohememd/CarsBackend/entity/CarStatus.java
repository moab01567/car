package site.mohememd.CarsBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car_status")
@Setter @Getter
public class CarStatus {

    @Id @Column(name = "carStatusID")
    private Integer carStatusId;

    @Column(name = "statusType")
    private String statusType;
}
