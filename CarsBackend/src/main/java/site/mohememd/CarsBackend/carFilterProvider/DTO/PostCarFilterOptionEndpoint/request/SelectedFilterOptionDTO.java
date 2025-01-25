package site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
public class SelectedFilterOptionDTO {
    private int carId;
    private List<SelectFilterDTO> selectFilters;
    private List<DateFilterDTO> dateFilters;


}
