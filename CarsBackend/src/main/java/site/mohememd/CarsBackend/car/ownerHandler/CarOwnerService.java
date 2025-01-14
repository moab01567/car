package site.mohememd.CarsBackend.car.ownerHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.mohememd.CarsBackend.Message;
import site.mohememd.CarsBackend.entity.car.Car;
import site.mohememd.CarsBackend.entity.car.CarCarRepository;
import site.mohememd.CarsBackend.entity.owners.CarOwnerRepository;
import site.mohememd.CarsBackend.entity.owners.Owners;
import site.mohememd.CarsBackend.entity.person.CarPersonRepository;
import site.mohememd.CarsBackend.entity.person.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarOwnerService {

    CarOwnerRepository carOwnerRepo;
    CarPersonRepository carPersonRepo;
    CarCarRepository carCarRepo;
    @Autowired
    public CarOwnerService(CarOwnerRepository carOwnerRepo, CarPersonRepository carPersonRepo, CarCarRepository carCarRepo) {
        this.carOwnerRepo = carOwnerRepo;
        this.carPersonRepo = carPersonRepo;
        this.carCarRepo = carCarRepo;
    }


    public List<Owners> getOwnersByCarReg(String reg){
        return carOwnerRepo.findOwnersByCarReg(reg);
    }

    public List<Owners> getOwnersByTlf(int tlf){
        return carOwnerRepo.findOwnersByPersonTlf(tlf);
    }

    public List<CarOwner> getCarOwnersById(Integer carId) {
        List<CarOwner> carOwners = new ArrayList<>();
        for (Owners owner : carOwnerRepo.findOwnersByCarCarId(carId)) {
            carOwners.add(new CarOwner(owner.getCar().getCarId(),
                    owner.getPerson().getTlf(),
                    owner.getPerson().getName(),
                    owner.getPerson().getPlace(),
                    owner.getPerson().isContacted()));
        }
        return carOwners;
    }

    public Message removeOwnerFromDataBase(int carID, int tlf) {
        carOwnerRepo.deleteOwnersByCarCarIdAndPersonTlf(carID,tlf);
        return new Message("Owner was removed");
    }

    @Transactional
    public Message addNewPersonIfNotInDatabaseThenAddToOwners(CarOwner carOwner) {
        Person person = new Person(
                carOwner.tlf(),
                carOwner.name(),
                carOwner.place(),
                carOwner.contacted());
        Car car = new Car();
        car.setCarId(carOwner.carID());
        Owners owners = new Owners(0,car,person);
        carPersonRepo.save(person);
        carOwnerRepo.save(owners);


        return new Message("all was good:)");
    }
}
