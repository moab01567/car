package site.mohememd.CarsBackend.carFilterProvider.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilterOptionDTO {
    private int optionId;
    private String option;
}
