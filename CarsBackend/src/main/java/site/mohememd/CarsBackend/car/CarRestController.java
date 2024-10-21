package site.mohememd.CarsBackend.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mohememd.CarsBackend.Message;
import site.mohememd.CarsBackend.car.carEdit.CarEditService;
import site.mohememd.CarsBackend.car.carProvider.CarProviderService;


@RequestMapping("/api/car")
@RestController
public class CarRestController {


    @Autowired
    CarProviderService carProviderService;

    @Autowired
    CarEditService carEditService;

    @GetMapping("/details/{carId}")
    public ResponseEntity<?> getCarDetailsByCarId(@PathVariable int carId){
        System.out.println(carId);
        Car car = carProviderService.getCarDetailsById(carId);

        return new ResponseEntity<>(car,HttpStatus.OK);
    }

    @PutMapping("update/carInfo")
    public ResponseEntity<Message> updateCarInfo(@RequestParam(value="updateType") String updateType,
                                                 @RequestParam(value="carId")int carId,
                                                 @RequestParam(value="value")int value){

       Message message = carEditService.UpdateCar(updateType,carId,value);
       return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("update/followUpDate")
    public ResponseEntity<Message> updateCarInfo(@RequestParam(value="carId")int carId,
                                                 @RequestParam(value="followUpDate") String followUpDate){

        Message message = carEditService.editCarFollowUpDate(carId,followUpDate);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }



}
