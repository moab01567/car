package site.mohememd.CarsBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "handle_status")
@Setter @Getter
public class HandleStatus {

    @Id @Column(name = "handleStatusID")
    private Integer handleStatusId;

    @Column(name = "handleName")
    private String handleName;


}
