package site.mohememd.CarsBackend.car.carProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.car.Car;

@Service
public class CarProviderService {
    @Autowired
    CarProviderRepository carProviderRepository;

    public Car getCarDetailsById(int carId) {

        return carProviderRepository.selectCarByID(carId);
    }

}
