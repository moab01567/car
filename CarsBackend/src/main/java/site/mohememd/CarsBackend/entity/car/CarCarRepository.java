package site.mohememd.CarsBackend.entity.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CarCarRepository extends JpaRepository<Car,Integer>{

}
