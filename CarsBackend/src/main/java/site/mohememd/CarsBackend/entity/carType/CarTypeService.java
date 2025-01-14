package site.mohememd.CarsBackend.entity.carType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.carFilterProvider.DTO.GET.CarAvailableDTO;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.AvailableCars;

import java.util.List;

@Service
public class CarTypeService implements AvailableCars {

    private final CarTypeRepository carTypeRepository;

    @Autowired
    public CarTypeService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    @Override
    public List<CarAvailableDTO> getAvailableCarsType() {
        return carTypeRepository.findAll().stream().map(carType -> {
            return CarAvailableDTO.builder()
                    .carId(carType.getCarTypeId())
                    .carName(carType.getCarModel())
                    .build();})
                .toList();
    }
}
