import {DateFilterCode, SelectFilterCode} from "../Enum";
import {FilterOption} from "../LocalStorageCarFilter";

export interface SelectedFilterOptionDTO {
    carId: number;
    selectFilters: {
        filterCode: string;
        selectedOptions: number[];
    }[];
    dateFilters: {
        filterCode: string;
        selectedDate: string;
    }[];
}

export function SelectedFilterOptionDTOMapper(filterData:Record<number, FilterOption>):SelectedFilterOptionDTO[]{
    const carIds:number[] =  Object.keys(filterData).map(key=> Number.parseInt(key))
    return carIds.map(carIdKey => {
       return {
           carId: carIdKey,
           selectFilters: filterData[carIdKey].selectFilters.map(selectFilter => (
               {filterCode: SelectFilterCode[selectFilter.filterCode], selectedOptions: selectFilter.selectedOptions})),
           dateFilters: filterData[carIdKey].dateFilters.map(dateFilter => (
               {filterCode: DateFilterCode[dateFilter.filterCode], selectedDate: dateFilter.selectedDate}))
       }
   })
}