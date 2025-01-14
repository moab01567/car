package site.mohememd.CarsBackend.carFilterProvider.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DateFilterDTO {
    private int dateFilterId;
    private String dateFilterName;
}
