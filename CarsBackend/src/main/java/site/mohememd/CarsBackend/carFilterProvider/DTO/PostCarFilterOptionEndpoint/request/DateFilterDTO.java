package site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request;

import lombok.Builder;
import lombok.Data;
import site.mohememd.CarsBackend.carFilterProvider.enums.DateFilterCode;

@Data @Builder
public class DateFilterDTO {
    private DateFilterCode filterCode;
    private String selectedDate;
}
