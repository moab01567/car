package site.mohememd.CarsBackend.car.ownerHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mohememd.CarsBackend.Message;

import java.util.List;

@RequestMapping("/api/car")
@RestController
public class OwnerRestController {

    CarOwnersService carOwnersService;
    CarOwnerService carOwnerService;

    @Autowired
    public OwnerRestController(CarOwnersService carOwnersService, CarOwnerService carOwnerService) {
        this.carOwnersService = carOwnersService;
        this.carOwnerService = carOwnerService;
    }

    @GetMapping("/owners/{carId}")
    public ResponseEntity<?> getOwnersByCarId(@PathVariable int carId){
        System.out.println(carId);
        List<CarOwner> carOwners = carOwnerService.getCarOwnersById(carId);

        return new ResponseEntity<>(carOwners, HttpStatus.OK);
    }

    @DeleteMapping(value = "/owner/remove")
    public ResponseEntity<?> deleteOwner(@RequestParam(value = "carId", defaultValue = "0") Integer carID,
                                         @RequestParam(value = "tlf", defaultValue = "0") Integer tlf){
        System.out.println(carID);
        System.out.println(tlf);
        Message message = carOwnerService.removeOwnerFromDataBase(carID, tlf);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("/owner/add")
    public ResponseEntity<?> addOwner(@RequestParam (value="carId") int carId,
                                      @RequestParam (value="ownerTlf") int ownerTlf,
                                      @RequestParam (value="ownerName") String ownerName,
                                      @RequestParam (value="place") String place,
                                      @RequestParam (value="contacted") boolean contacted){

        Message carAndOwners = carOwnerService.addNewPersonIfNotInDatabaseThenAddToOwners(new CarOwner(carId,ownerTlf, ownerName, place,contacted));
        return new ResponseEntity<>(carAndOwners,HttpStatus.OK);
    }
}
