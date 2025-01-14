package site.mohememd.CarsBackend.entity.carFuel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel,Integer> {
    List<CarFuel> findByCars_CarType_CarTypeId(Integer carsCarTypeCarTypeId);
}