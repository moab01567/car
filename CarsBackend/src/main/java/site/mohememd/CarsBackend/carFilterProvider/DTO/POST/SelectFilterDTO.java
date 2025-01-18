package site.mohememd.CarsBackend.carFilterProvider.DTO.POST;

import lombok.Builder;
import lombok.Data;
import site.mohememd.CarsBackend.carFilterProvider.FilterCode;

import java.util.List;

@Data @Builder
public class SelectFilterDTO {
    private FilterCode filterCode;
    private List<Integer> selectedOptions;
}
