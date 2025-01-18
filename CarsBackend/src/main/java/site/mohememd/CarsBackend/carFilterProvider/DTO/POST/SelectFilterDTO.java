package site.mohememd.CarsBackend.carFilterProvider.DTO.POST;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
public class SelectFilterDTO {
    private String filterCode;
    private List<Integer> selectedOptions;
}
