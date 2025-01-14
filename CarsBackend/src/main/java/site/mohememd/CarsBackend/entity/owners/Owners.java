package site.mohememd.CarsBackend.entity.owners;

import jakarta.persistence.*;
import lombok.*;
import site.mohememd.CarsBackend.entity.car.Car;
import site.mohememd.CarsBackend.entity.person.Person;

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
