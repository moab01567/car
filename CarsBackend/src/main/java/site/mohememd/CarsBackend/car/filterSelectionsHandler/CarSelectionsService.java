package site.mohememd.CarsBackend.car.filterSelectionsHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarSelectionsService {
    @Autowired
    CarSelectionsRepository carSelectionsRepository;
    public List<CarReg> getAllRegNumbersBySelections(CarSelections carSelections){
        return carSelectionsRepository.selectCarsRegByOptions(carSelections);
    }
    public List<CarReg> getAllCarRegBy_Tlf_Selections(int tlf){
        return carSelectionsRepository.selectCarsRegByTlf(tlf);
    }


    public List<CarReg> getAllCarRegBy_Reg_Selections(String reg) {
        return carSelectionsRepository.selectCarsRegByReg(reg);
    }
}
