package site.mohememd.CarsBackend.entity.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request.RequestMainCarFilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.response.CarRegDTO;

import java.util.List;

@Service
public class CarService{

    private final CarCarRepository carCarRepo;
    private final JooqRepository jooqRepo;
    @Autowired
    public CarService(CarCarRepository carCarRepo, JooqRepository jooqRepo) {
        this.carCarRepo = carCarRepo;
        this.jooqRepo = jooqRepo;
    }

    public List<CarRegDTO> filterCars(RequestMainCarFilterOptionDTO selectedFilterOptionDTO){
        return jooqRepo.filterCars(selectedFilterOptionDTO);
    }

}
