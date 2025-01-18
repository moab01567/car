package site.mohememd.CarsBackend.entity.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarCarRepository extends JpaRepository<Car,Integer> {

    @Query("select Car from Car c WHERE c.carType.carTypeId = :carTypeId " +
            "And c.transmission.transmissionId = :transmissionIds " +
            "And c.carFuel.carFuelId = :carFuelIds " +
            "And c.carStatus.carStatusId = :carStatusId " +
            "And c.handleStatus.handleStatusId = :handleStatusIds " +
            "And c.totalSeats = :totalSeats " +
            "And c.reg between :regDateFrom and :regDateTo " +
            "And c.nextEUControl between :nextEUDateFrom and :nextEUDateTo ")
    List<Car> filterCars(@Param("carTypeId") Integer carTypeId,
                       @Param("transmissionIds") List<Integer> transmissionIds,
                       @Param("carFuelIds") List<Integer> carFuelIds,
                       @Param("carStatusId") List<Integer> carStatusId,
                       @Param("handleStatusIds") List<Integer> handleStatusIds,
                       @Param("totalSeats") List<Integer> totalSeats,
                       @Param("regDateFrom") String regDateFrom,
                       @Param("regDateTo") String regDateTo,
                       @Param("nextEUDateFrom") String nextEUDateFrom,
                       @Param("nextEUDateTo") String nextEUDateTo);
}
