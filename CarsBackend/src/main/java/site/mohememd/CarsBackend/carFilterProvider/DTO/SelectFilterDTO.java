package site.mohememd.CarsBackend.carFilterProvider.DTO;

import lombok.Builder;
import lombok.Data;
import site.mohememd.CarsBackend.carFilterProvider.FilterCode;


import java.util.List;

@Data
@Builder
public class SelectFilterDTO {
    FilterCode filterCode;
    String filterName;
    List<FilterOptionDTO> filterOptionDTOS;
}
