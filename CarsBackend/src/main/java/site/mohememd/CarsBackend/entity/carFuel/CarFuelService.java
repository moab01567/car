package site.mohememd.CarsBackend.entity.carFuel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.carFilterProvider.DTO.GetFilterOptionEndpoint.FilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.FilterOption;


import java.util.List;


@Service
public class CarFuelService implements FilterOption {

    private final CarFuelRepository carFuelRepository;

    @Autowired
    public CarFuelService(CarFuelRepository carFuelRepository) {
        this.carFuelRepository = carFuelRepository;
    }

    @Override
    public List<FilterOptionDTO> getFilterOption(int carTypeId) {
        return carFuelRepository.findAll().stream().map(
                carFuel ->
                        FilterOptionDTO.builder()
                                .optionId(carFuel.getCarFuelId())
                                .option(carFuel.getFuelName())
                                .build()).toList();
    }
}
