package site.mohememd.CarsBackend.entity.car;

import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.response.CarRegDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request.DateFilterDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request.SelectFilterDTO;
import site.mohememd.CarsBackend.carFilterProvider.DTO.PostCarFilterOptionEndpoint.request.SelectedFilterOptionDTO;
import site.mohememd.CarsBackend.exceptions.FilterNotFound;

import java.util.List;

@Repository
public class JooqRepository {

    private final DSLContext create;

    @Autowired
    public JooqRepository(DSLContext create) {
        this.create = create;
    }

    public List<CarRegDTO> filterCars(List<SelectedFilterOptionDTO> selectedFilterOptionDTO) {
        SelectConditionStep<Record4<Integer, String,String,String>> query = createWithNoResult();

        for (SelectedFilterOptionDTO filterOptionDTO : selectedFilterOptionDTO) {
            SelectConditionStep<Record4<Integer, String,String,String>>  carQuery = create
                    .select(CarTable.CAR_ID, CarTable.REG,CarTable.NEXT_EU_CONTROL,CarTable.FOLLOW_UP)
                    .from(CarTable.TABLE)
                    .where(CarTable.CAR_TYPE_ID.eq(filterOptionDTO.getCarId()));
           addSelectFilterCondition(carQuery,filterOptionDTO.getSelectFilters());
           addDateFilterCondition(carQuery,filterOptionDTO.getDateFilters());
           query.unionAll(carQuery);
        }

        query.orderBy(CarTable.NEXT_EU_CONTROL);
        query.limit(10);
        System.out.println(query);
        List<CarRegDTO> carRegDTOs = query.fetch().map(record -> new CarRegDTO(record.component1(),record.component2()));
        return carRegDTOs;
    }

    private void addDateFilterCondition(SelectConditionStep<Record4<Integer, String, String, String>> carQueryCondition, List<DateFilterDTO> dateFilters) {
        for (DateFilterDTO dateFilterDTO : dateFilters) {
            if (dateFilterDTO.getSelectedDate() == null || dateFilterDTO.getSelectedDate().isEmpty()) return;

            switch (dateFilterDTO.getFilterCode()) {
                case EU_TO -> carQueryCondition.and(CarTable.NEXT_EU_CONTROL.lessOrEqual(dateFilterDTO.getSelectedDate()));
                case EU_FROM -> carQueryCondition.and(CarTable.NEXT_EU_CONTROL.greaterOrEqual(dateFilterDTO.getSelectedDate()));
                case REG_FROM -> carQueryCondition.and(CarTable.REG.greaterOrEqual(dateFilterDTO.getSelectedDate()));
                case REG_TO -> carQueryCondition.and(CarTable.REG.lessOrEqual(dateFilterDTO.getSelectedDate()));
                default -> throw new FilterNotFound(dateFilterDTO.getFilterCode().toString());
            }
        }
    }

    private void addSelectFilterCondition(SelectConditionStep<Record4<Integer, String, String, String>> carQueryCondition, List<SelectFilterDTO> selectFilters) {

        for (SelectFilterDTO selectFilter : selectFilters) {
            if (selectFilter.getSelectedOptions().isEmpty()) continue;

            switch (selectFilter.getFilterCode()) {
                case CAR_TRANSMISSION ->  carQueryCondition.and(CarTable.TRANSMISSION_ID.in(selectFilter.getSelectedOptions()));
                case CAR_FUEL ->  carQueryCondition.and(CarTable.FUEL_ID.in(selectFilter.getSelectedOptions()));
                case CAR_SEATS -> carQueryCondition.and(CarTable.TOTAL_SEATS.in(selectFilter.getSelectedOptions()));
                case CAR_STATUS -> carQueryCondition.and(CarTable.STATUS_ID.in(selectFilter.getSelectedOptions()));
                case HANDLE_STATUS -> carQueryCondition.and(CarTable.HANDLE_STATUS_ID.in(selectFilter.getSelectedOptions()));
                default -> throw new FilterNotFound(selectFilter.getFilterCode().toString());
            }
        }
    }

    private SelectConditionStep<Record4<Integer, String, String, String>> createWithNoResult() {
        SelectConditionStep<Record4<Integer, String,String,String>>  query = create
                 .select(CarTable.CAR_ID, CarTable.REG, CarTable.NEXT_EU_CONTROL,CarTable.FOLLOW_UP)
                 .from(CarTable.TABLE).where(CarTable.CAR_ID.isNull());
        return query;
    }


}
