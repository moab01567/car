package site.mohememd.CarsBackend.entity.carStatus;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.carFilterProvider.DTO.FilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.FilterOption;

import java.util.List;

@Service
public class CarStatusService implements FilterOption {

    private final CarStatusRepository carStatusRepository;
    @Autowired
    public CarStatusService(CarStatusRepository carStatusRepository) {
        this.carStatusRepository = carStatusRepository;
    }

    @Override
    public List<FilterOptionDTO> getFilterOption(int carTypeId) {
        return carStatusRepository.findAll().stream().map(
                carFuel ->
                        FilterOptionDTO.builder()
                                .optionId(carFuel.getCarStatusId())
                                .option(carFuel.getStatusType())
                                .build()).toList();
    }
}
