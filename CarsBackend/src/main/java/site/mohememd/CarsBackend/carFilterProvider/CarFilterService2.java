package site.mohememd.CarsBackend.carFilterProvider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.carFilterProvider.DTO.CarAvailableDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.FilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.SelectFilterDTO;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.AvailableCars;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.FilterOption;
import site.mohememd.CarsBackend.entity.carStatus.CarStatusService;
import site.mohememd.CarsBackend.entity.carType.CarTypeService;
import site.mohememd.CarsBackend.entity.handleStatus.HandleStatusService;
import site.mohememd.CarsBackend.entity.transmission.TransmissionService;
import site.mohememd.CarsBackend.exceptions.FilterNotFound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CarFilterService2 {
    private final FilterOption carFuelService;
    private final FilterOption carStatusService;
    private final FilterOption transmissionService;
    private final FilterOption handleStatusService;
    private final AvailableCars carTypeService;

    @Autowired
    public CarFilterService2(FilterOption carFuelService, CarStatusService carStatusService, TransmissionService transmissionService, HandleStatusService handleStatusService, CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
        this.carFuelService = carFuelService;
        this.carStatusService = carStatusService;
        this.transmissionService = transmissionService;
        this.handleStatusService = handleStatusService;
    }

    public List<CarAvailableDTO> getAvailableCarsToFilter(){
       return carTypeService.getAvailableCarsType();
    }

    public SelectFilterDTO getFiltersAndFilterOptions(int carTypeId, FilterCode selectedFilterCode) {
        switch (selectedFilterCode) {
            case CAR_FUEL -> {
                return getSelectFilterDTO(carTypeId, FilterCode.CAR_FUEL, carFuelService);
            }
            case CAR_STATUS -> {
                return getSelectFilterDTO(carTypeId, FilterCode.CAR_STATUS, carStatusService);
            }
            case CAR_TRANSMISSION -> {
                return getSelectFilterDTO(carTypeId, FilterCode.CAR_TRANSMISSION, transmissionService);
            }
            case HANDLE_STATUS -> {
                return getSelectFilterDTO(carTypeId, FilterCode.HANDLE_STATUS, handleStatusService);

            }case CAR_SEATS -> {
                return getCarSeats();
            }
            default -> throw new FilterNotFound(selectedFilterCode.toString());
        }
    }

    private SelectFilterDTO getCarSeats() {
        List<Integer> seats = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<FilterOptionDTO> filterOptionDTOS = seats.stream().map(seat ->{
            return FilterOptionDTO.builder().option(seat.toString()).optionId(seat).build();
        }).toList();

        return SelectFilterDTO.builder()
                .filterCode(FilterCode.CAR_SEATS)
                .filterName(FilterCode.CAR_SEATS.toString().toLowerCase())
                .filterOptionDTOS(filterOptionDTOS)
                .build();
    }

    private SelectFilterDTO getSelectFilterDTO(int carTypeId, FilterCode filterCode, FilterOption filterOption) {
        return SelectFilterDTO.builder()
                .filterCode(filterCode)
                .filterName(filterCode.toString().toLowerCase())
                .filterOptionDTOS(filterOption.getFilterOption(carTypeId))
                .build();
    }
}
