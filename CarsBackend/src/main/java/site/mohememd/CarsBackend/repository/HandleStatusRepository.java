package site.mohememd.CarsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.entity.HandleStatus;
@Repository
public interface HandleStatusRepository extends JpaRepository<HandleStatus,Integer> {
}
