package site.mohememd.CarsBackend.carFilterProvider.interfaces;

import site.mohememd.CarsBackend.carFilterProvider.DTO.GetFilterOptionEndpoint.FilterOptionDTO;

import java.util.List;

public interface FilterOption {
    public List<FilterOptionDTO> getFilterOption(int carTypeId);
}