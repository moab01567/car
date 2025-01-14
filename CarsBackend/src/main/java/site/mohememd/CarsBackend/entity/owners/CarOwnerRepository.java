package site.mohememd.CarsBackend.entity.owners;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarOwnerRepository extends JpaRepository<Owners, Integer> {

    List<Owners> findOwnersByCarReg(String reg);

    List<Owners> findOwnersByPersonTlf(int tlf);

    List<Owners> findOwnersByCarCarId(Integer carId);

    @Transactional
    void deleteOwnersByCarCarIdAndPersonTlf(Integer carId, Integer tlf);


}
