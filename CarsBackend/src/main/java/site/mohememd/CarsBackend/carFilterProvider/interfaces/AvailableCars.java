package site.mohememd.CarsBackend.carFilterProvider.interfaces;

import site.mohememd.CarsBackend.carFilterProvider.DTO.GET.CarAvailableDTO;

import java.util.List;

public interface AvailableCars {
    List<CarAvailableDTO> getAvailableCarsType();
}
