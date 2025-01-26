package site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request;

import lombok.Builder;
import lombok.Data;
import site.mohememd.CarsBackend.carFilterProvider.enums.SortCode;

import java.util.List;
@Data
@Builder
public class RequestMainCarFilterOptionDTO {
    private SortCode sortCode;
    private List<SelectedFilterOptionDTO> selectedFilterOptions;
}
