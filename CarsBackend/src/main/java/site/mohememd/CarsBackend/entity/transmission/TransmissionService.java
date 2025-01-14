package site.mohememd.CarsBackend.entity.transmission;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.carFilterProvider.DTO.FilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.FilterOption;

import java.util.List;


@Service
public class TransmissionService implements FilterOption {


    private final TransmissionRepository transmissionRepository;

    @Autowired
    public TransmissionService(TransmissionRepository transmissionRepository) {
        this.transmissionRepository = transmissionRepository;
    }

    @Override
    public List<FilterOptionDTO> getFilterOption(int carTypeId) {
        return transmissionRepository.findAll().stream().map(
                transmission ->
                        FilterOptionDTO.builder()
                                .optionId(transmission.getTransmissionId())
                                .option(transmission.getTransmissionType())
                                .build()).toList();
    }
}
