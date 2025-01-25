package site.mohememd.CarsBackend.carFilterProvider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mohememd.CarsBackend.carFilterProvider.DTO.GetCarAvailableEndpoint.CarAvailableDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.GetFilterOptionEndpoint.SelectFilterDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.response.CarRegDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request.SelectedFilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.enums.SelectorFilterCode;

import java.util.List;
@RequestMapping("/car/filter")
@RestController
public class CarFilterController {

    private final CarFilterService2 carFilterService2;

    @Autowired
    public CarFilterController(CarFilterService2 carFilterService2) {
        this.carFilterService2 = carFilterService2;
    }

    @GetMapping("/available/cars")
    public ResponseEntity<List<CarAvailableDTO>> getAvailableCarsToFilter(){
        return new ResponseEntity<>(carFilterService2.getAvailableCarsToFilter(), HttpStatus.OK);
    }

    @GetMapping("/{carTypeId}/{filterCode}")
    public ResponseEntity<SelectFilterDTO> getCarFiltersAndOptionsByCarId(@PathVariable int carTypeId, @PathVariable String filterCode){
        ValidateCarFilterEndpoint.validateCarFilterCode(filterCode);
        return new ResponseEntity<>(carFilterService2.getFiltersAndFilterOptions(carTypeId, SelectorFilterCode.valueOf(filterCode)), HttpStatus.OK);
    }

    @PostMapping("/options")
    public ResponseEntity<List<CarRegDTO>> addCarFilter(@RequestBody List<SelectedFilterOptionDTO> selectedFilterOptionDTO){
        return new ResponseEntity<List<CarRegDTO>>(carFilterService2.filterCars(selectedFilterOptionDTO),HttpStatus.OK);
    }
}

