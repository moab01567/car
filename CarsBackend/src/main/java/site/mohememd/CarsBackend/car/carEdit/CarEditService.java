package site.mohememd.CarsBackend.car.carEdit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.Message;

@Service
public class CarEditService {
    @Autowired
    CarEditRepository carEditRepository;

    public Message UpdateCar(String carType, int carId, int value){
       return carEditRepository.updateCar(carId,value);
    }

    public Message editCarFollowUpDate( int carId, String date){
        if (date.equals("null"))date=null;
        return carEditRepository.UpdateCarFollowUpDate(carId,date);
    }

}
