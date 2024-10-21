package site.mohememd.CarsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.entity.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType,Integer> {
}