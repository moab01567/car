package site.mohememd.CarsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.entity.CarFuel;

@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel,Integer> {
}