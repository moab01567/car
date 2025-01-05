package site.mohememd.CarsBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "handle_status")
@Setter @Getter
public class HandleStatus {

    @Id @Column(name = "handleStatusID")
    private Integer handleStatusId;

    @Column(name = "handleName")
    private String handleName;

    @OneToMany(mappedBy = "handleStatus")
    private List<Car> cars;

}
