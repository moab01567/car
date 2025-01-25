package site.mohememd.CarsBackend.carFilterProvider.DTO.GetFilterOptionEndpoint;

import lombok.Builder;
import lombok.Data;
import site.mohememd.CarsBackend.carFilterProvider.enums.SelectorFilterCode;


import java.util.List;

@Data
@Builder
public class SelectFilterDTO {
    SelectorFilterCode selectorFilterCode;
    String filterName;
    List<FilterOptionDTO> filterOptionDTOS;
}
