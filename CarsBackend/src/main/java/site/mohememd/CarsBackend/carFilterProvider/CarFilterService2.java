package site.mohememd.CarsBackend.carFilterProvider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.carFilterProvider.DTO.GetCarAvailableEndpoint.CarAvailableDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.GetFilterOptionEndpoint.FilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.GetFilterOptionEndpoint.SelectFilterDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.response.CarRegDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request.SelectedFilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.enums.SelectorFilterCode;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.AvailableCars;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.FilterOption;
import site.mohememd.CarsBackend.entity.car.CarService;
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
    private final CarService carService;

    @Autowired
    public CarFilterService2(FilterOption carFuelService, CarStatusService carStatusService, TransmissionService transmissionService, HandleStatusService handleStatusService, CarTypeService carTypeService, CarService carService) {
        this.carTypeService = carTypeService;
        this.carFuelService = carFuelService;
        this.carStatusService = carStatusService;
        this.transmissionService = transmissionService;
        this.handleStatusService = handleStatusService;
        this.carService = carService;
    }

    public List<CarAvailableDTO> getAvailableCarsToFilter(){
       return carTypeService.getAvailableCarsType();
    }


    public List<CarRegDTO> filterCars(List<SelectedFilterOptionDTO> selectedFilterOptionDTO) {
        return carService.filterCars(selectedFilterOptionDTO);
    }

    public SelectFilterDTO getFiltersAndFilterOptions(int carTypeId, SelectorFilterCode selectedFilterCode) {
        switch (selectedFilterCode) {
            case CAR_FUEL -> {
                return getSelectFilterDTO(carTypeId, SelectorFilterCode.CAR_FUEL, carFuelService);
            }
            case CAR_STATUS -> {
                return getSelectFilterDTO(carTypeId, SelectorFilterCode.CAR_STATUS, carStatusService);
            }
            case CAR_TRANSMISSION -> {
                return getSelectFilterDTO(carTypeId, SelectorFilterCode.CAR_TRANSMISSION, transmissionService);
            }
            case HANDLE_STATUS -> {
                return getSelectFilterDTO(carTypeId, SelectorFilterCode.HANDLE_STATUS, handleStatusService);

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
                .selectorFilterCode(SelectorFilterCode.CAR_SEATS)
                .filterName(SelectorFilterCode.CAR_SEATS.toString().toLowerCase())
                .filterOptionDTOS(filterOptionDTOS)
                .build();
    }

    private SelectFilterDTO getSelectFilterDTO(int carTypeId, SelectorFilterCode selectorFilterCode, FilterOption filterOption) {
        return SelectFilterDTO.builder()
                .selectorFilterCode(selectorFilterCode)
                .filterName(selectorFilterCode.toString().toLowerCase())
                .filterOptionDTOS(filterOption.getFilterOption(carTypeId))
                .build();
    }
}
