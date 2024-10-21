package site.mohememd.CarsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.entity.CarStatus;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus,Integer> {
}
