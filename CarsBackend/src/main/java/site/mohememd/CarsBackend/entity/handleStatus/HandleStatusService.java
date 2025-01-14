package site.mohememd.CarsBackend.entity.handleStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.carFilterProvider.DTO.FilterOptionDTO;
import site.mohememd.CarsBackend.carFilterProvider.interfaces.FilterOption;

import java.util.List;

@Service
public class HandleStatusService implements FilterOption {
    private final HandleStatusRepository handleStatusRepository;

    @Autowired
    public HandleStatusService(HandleStatusRepository handleStatusRepository) {
        this.handleStatusRepository = handleStatusRepository;
    }

    @Override
    public List<FilterOptionDTO> getFilterOption(int carTypeId) {
        return handleStatusRepository.findAll().stream().map(
                handleStatus ->
                        FilterOptionDTO.builder()
                                .optionId(handleStatus.getHandleStatusId())
                                .option(handleStatus.getHandleName())
                                .build()).toList();
    }
}
