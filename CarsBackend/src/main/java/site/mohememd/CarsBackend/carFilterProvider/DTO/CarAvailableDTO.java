package site.mohememd.CarsBackend.carFilterProvider.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarAvailableDTO {
    int carId;
    String carName;
}
