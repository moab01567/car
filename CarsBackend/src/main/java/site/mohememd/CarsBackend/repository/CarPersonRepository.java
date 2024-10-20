package site.mohememd.CarsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.entity.Person;
@Repository
public interface CarPersonRepository extends JpaRepository<Person, Integer> {

}
