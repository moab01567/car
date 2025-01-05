package site.mohememd.CarsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.entity.CarFuel;


import java.util.List;

@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel,Integer> {
    List<CarFuel> findByCars_CarType_CarTypeId(Integer carsCarTypeCarTypeId);
}