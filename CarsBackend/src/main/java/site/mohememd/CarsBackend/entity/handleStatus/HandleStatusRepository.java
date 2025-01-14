package site.mohememd.CarsBackend.entity.handleStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleStatusRepository extends JpaRepository<HandleStatus,Integer> {
}
