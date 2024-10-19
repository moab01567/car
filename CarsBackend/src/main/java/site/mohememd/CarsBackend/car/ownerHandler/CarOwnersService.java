package site.mohememd.CarsBackend.car.ownerHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.Message;

import java.util.List;

@Service
public class CarOwnersService {

    private final CarOwnersRepository carOwnersRepository;

    @Autowired
    public CarOwnersService(CarOwnersRepository carOwnersRepository) {
        this.carOwnersRepository = carOwnersRepository;
    }

    public List<CarOwner> getCarOwnersById(int carId) {
        return carOwnersRepository.selectOwnersByCarId(carId);
    }

    public Message RemoveOwnerFromDataBase(int carID, int tlf){
        return carOwnersRepository.deleteOwnerFromTable(carID,tlf);
    }
    public Message addNewPersonAndGetTheCurrentCarAndOwners(CarOwner carOwner){
        System.out.println(carOwner);
        return carOwnersRepository.insertOwner(carOwner);


    }
}
