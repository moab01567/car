package site.mohememd.CarsBackend.entity.car;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import site.mohememd.CarsBackend.entity.carFuel.CarFuel;
import site.mohememd.CarsBackend.entity.carStatus.CarStatus;
import site.mohememd.CarsBackend.entity.carType.CarType;
import site.mohememd.CarsBackend.entity.handleStatus.HandleStatus;
import site.mohememd.CarsBackend.entity.owners.Owners;
import site.mohememd.CarsBackend.entity.transmission.Transmission;

@Entity
@Getter @Setter
@Table(name = "car")
public class Car {
    @OneToMany(mappedBy = "car")
    private List<Owners> owners;

    @Id @Column(name = "carID" ,columnDefinition = "carID")
    private Integer carId;

    @Column(name = "reg",columnDefinition = "reg")
    private String reg;

    @Column(name = "vin",columnDefinition = "vin")
    private String vin;

    @Column(name = "color",columnDefinition = "color")
    private String color;

    @Column(name = "totalDoors",columnDefinition = "totalDoors")
    private Integer totalDoors;

    @Column(name = "totalSeats",columnDefinition = "totalSeats")
    private Integer totalSeats;

    @Column(name = "axlesInUse",columnDefinition = "axlesInUse")
    private Integer axlesInUse;

    @Column(name = "totalEngines",columnDefinition = "totalEngines")
    private Integer totalEngines;

    @Column(name = "length",columnDefinition = "length")
    private Float length;

    @Column(name = "width",columnDefinition = "width")
    private Float width;

    @Column(name = "registeredFirst",columnDefinition = "registeredFirst")
    private Date registeredFirst;

    @Column(name = "registeredNorway",columnDefinition = "registeredNorway")
    private Date registeredNorway;

    @Column(name = "nextEUControl",columnDefinition = "nextEUControl")
    private Date nextEUControl;

    @Column(name = "note",columnDefinition = "note")
    private String note;

    @Column(name = "followUp",columnDefinition = "followUp")
    private Date followUp;

    @ManyToOne()
    @JoinColumn(name = "transmissionID",columnDefinition = "transmissionID")
    private Transmission transmission;

    @ManyToOne()
    @JoinColumn(name = "statusID",columnDefinition = "statusID")
    private CarStatus carStatus;

    @ManyToOne()
    @JoinColumn(name = "carTypeID",columnDefinition = "carTypeID")
    private CarType carType;

    @ManyToOne()
    @JoinColumn(name = "fuelID",columnDefinition = "fuelID")
    private CarFuel carFuel;

    @ManyToOne()
    @JoinColumn(name = "handleStatusID",columnDefinition = "handleStatusID")
    private HandleStatus handleStatus;

}
