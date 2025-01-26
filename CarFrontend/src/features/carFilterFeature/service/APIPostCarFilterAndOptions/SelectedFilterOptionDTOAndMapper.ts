import {DateFilterCode, SelectFilterCode, SortFilterCode} from "../../Enum";
import {FilterOption} from "../../LocalStorageCarFilter";

export interface APIPostCarFilterAndOptionsDTO{
    sortCode:string |null;
    selectedFilterOptions:SelectedFilterOptionDTO[];
}

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

export function CarFilterAndOptionMapper(sortFilterCode:SortFilterCode | null, filterData:Record<number, FilterOption>):APIPostCarFilterAndOptionsDTO{
    const carIds:number[] =  Object.keys(filterData).map(key=> Number.parseInt(key))


    const selectedFilterOptionDTOs: SelectedFilterOptionDTO[] = carIds.map(carIdKey => {
       return {
           carId: carIdKey,
           selectFilters: filterData[carIdKey].selectFilters.map(selectFilter => (
               {filterCode: SelectFilterCode[selectFilter.filterCode], selectedOptions: selectFilter.selectedOptions})),
           dateFilters: filterData[carIdKey].dateFilters.map(dateFilter => (
               {filterCode: DateFilterCode[dateFilter.filterCode], selectedDate: dateFilter.selectedDate}))
       }

   })
    return {sortCode:sortFilterCode !== null ? SortFilterCode[sortFilterCode] : null, selectedFilterOptions:selectedFilterOptionDTOs}
}