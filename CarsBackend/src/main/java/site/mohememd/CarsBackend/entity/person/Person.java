package site.mohememd.CarsBackend.entity.person;


import jakarta.persistence.*;
import lombok.*;
import site.mohememd.CarsBackend.entity.owners.Owners;

import java.util.List;


@Entity @Table(name="person")
@NoArgsConstructor
@Getter @Setter
public class Person {
    @Id @Column(name = "tlf")
    private Integer tlf;
    @Column(name = "pName", columnDefinition ="pName")
    private  String name;
    @Column(name = "sted")
    private  String place;
    @Column(name = "contacted")
    private boolean contacted;

    @OneToMany(mappedBy = "person")
    private List<Owners> owners;

    public Person(Integer tlf, String name, String place, boolean contacted) {
        this.contacted = contacted;
        this.name = name;
        this.place = place;
        this.tlf = tlf;
    }
}
