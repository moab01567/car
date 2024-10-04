package site.mohememd.CarsBackend.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mohememd.CarsBackend.car.filterOptionsProvider2.CarFilterService;
import site.mohememd.CarsBackend.car.filterSelectionsHandler.CarReg;
import site.mohememd.CarsBackend.car.filterSelectionsHandler.CarSelections;
import site.mohememd.CarsBackend.car.filterSelectionsHandler.CarSelectionsService;
import site.mohememd.CarsBackend.exceptions.SomethingIsWrongWithDatabase;

import java.util.List;

@RequestMapping("/api/car")
@RestController
public class FilterAndSelectionRestController {
    @Autowired
    CarFilterService carFilterService ;
    @Autowired
    CarSelectionsService carSelectionsService ;

    @GetMapping("/filter-options/v2")
    public ResponseEntity<?> getFilterOptionsV2(@RequestParam(value = "filterType") String filterType ){
        List<?> filterOptions = carFilterService.getFilterOptions(filterType);
        return new ResponseEntity<>(filterOptions, HttpStatus.OK);
    }

    @GetMapping("/selected-options/v2")
    public ResponseEntity<?> selectedOptionsV2(
            @RequestParam(value="carTypesIds", required = false) List<Integer> carTypesIds,
            @RequestParam(value="carFuelIds", required = false) List<Integer> carFuelIds,
            @RequestParam(value="carStatusIds", required = false) List<Integer> carStatusIds,
            @RequestParam(value="handleStatusIds", required = false) List<Integer> handleStatusIds,
            @RequestParam(value="carSeatsIds", required = false) List<Integer> carSeatsIds,
            @RequestParam(value="transmissionIds", required = false) List<Integer> transmissionIds,
            @RequestParam(value="carFrom", required = false,defaultValue = "") String carFrom,
            @RequestParam(value="carTo", required = false ,defaultValue = "") String carTo,
            @RequestParam(value="euFRom", required = false,defaultValue = "") String euFrom,
            @RequestParam(value="euTo", required = false,defaultValue = "") String euTo) {

        List<CarReg> carRegs = carSelectionsService.getAllRegNumbersBySelections(new CarSelections(carTypesIds,transmissionIds,carFuelIds,carStatusIds,handleStatusIds,carSeatsIds,carFrom,carTo,euFrom,euTo));

        if (carRegs==null){
            throw new SomethingIsWrongWithDatabase();
        }
        return new ResponseEntity<>(carRegs,HttpStatus.OK);
    }

    @GetMapping("/tlf/selections/{tlf}")
    public ResponseEntity<?>  getCarsByTlf(@PathVariable int tlf){
        List<CarReg> carRegs = carSelectionsService.getAllCarRegBy_Tlf_Selections(tlf);
        return new ResponseEntity<>(carRegs,HttpStatus.OK);
    }
    @GetMapping("/reg/selections/{reg}")
    public ResponseEntity<?>  getCarsRegTlf(@PathVariable String reg){
        List<CarReg> carRegs = carSelectionsService.getAllCarRegBy_Reg_Selections(reg);
        return new ResponseEntity<>(carRegs,HttpStatus.OK);
    }
}
