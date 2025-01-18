package site.mohememd.CarsBackend.carFilterProvider.DTO.POST;

import lombok.Builder;
import lombok.Data;
import site.mohememd.CarsBackend.carFilterProvider.FilterCode;

@Data @Builder
public class DateFilterDTO {
    private FilterCode filterCode;
    private String selectedDate;
}
