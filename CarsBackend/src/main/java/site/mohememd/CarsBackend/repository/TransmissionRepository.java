package site.mohememd.CarsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.entity.Transmission;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission,Integer> {
}
