package site.mohememd.CarsBackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "owners")
@NoArgsConstructor
public class Owners {

    @ManyToOne
    @JoinColumn(name = "CarID",columnDefinition ="CarID")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "tlf")
    private Person person;

    @Id
    private Integer id;

    public Owners(Integer id,Car car, Person person) {
        this.id = id;
        this.car = car;
        this.person = person;
    }
}
