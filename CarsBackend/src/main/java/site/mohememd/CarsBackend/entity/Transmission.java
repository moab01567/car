package site.mohememd.CarsBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transmission")
@Setter @Getter
public class Transmission {

    @Id @Column(name = "transmissionID")
    private Integer transmissionId;

    @Column(name = "transmissionType")
    private String transmissionType;
}
