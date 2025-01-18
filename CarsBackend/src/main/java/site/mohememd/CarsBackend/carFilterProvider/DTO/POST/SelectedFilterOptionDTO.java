package site.mohememd.CarsBackend.carFilterProvider.DTO.POST;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
public class SelectedFilterOptionDTO {
    private int carId;
    private List<SelectFilterDTO> selectFilters;
    private List<DateFilterDTO> dateFilters;


}
