package site.mohememd.CarsBackend.entity.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPersonRepository extends JpaRepository<Person, Integer> {

}
