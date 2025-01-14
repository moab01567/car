package site.mohememd.CarsBackend.carFilterProvider.DTO.GET;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarFiltersAndOptionsDTO {
    int carId;
    List<SelectFilterDTO> selectFilterDTOs;
    List<DateFilterDTO> dateFilterDTOs;
}
