package site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request;

import lombok.Builder;
import lombok.Data;
import site.mohememd.CarsBackend.carFilterProvider.enums.SelectorFilterCode;

import java.util.List;

@Data @Builder
public class SelectFilterDTO {
    private SelectorFilterCode filterCode;
    private List<Integer> selectedOptions;
}
