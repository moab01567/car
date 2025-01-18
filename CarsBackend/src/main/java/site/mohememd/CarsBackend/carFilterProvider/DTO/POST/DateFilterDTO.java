package site.mohememd.CarsBackend.carFilterProvider.DTO.POST;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class DateFilterDTO {
    private String filterCode;
    private String selectedDate;
}
