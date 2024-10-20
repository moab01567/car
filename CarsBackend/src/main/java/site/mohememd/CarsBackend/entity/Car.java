package site.mohememd.CarsBackend.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "transmissionID",columnDefinition = "transmissionID")
    private Integer transmissionId;

    @Column(name = "statusID",columnDefinition = "statusID")
    private Integer statusId;

    @Column(name = "carTypeID",columnDefinition = "carTypeID")
    private Integer carTypeId;

    @Column(name = "fuelID",columnDefinition = "fuelID")
    private Integer fuelId;

    @Column(name = "handleStatusID",columnDefinition = "handleStatusID")
    private Integer handleStatusId;

}
