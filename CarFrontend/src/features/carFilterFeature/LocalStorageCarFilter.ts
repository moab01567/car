import { DateFilterCode, SelectFilterCode, StorageKey } from "./Enum";

export interface FilterOption {
  selectFilters: {
    filterCode: SelectFilterCode;
    selectedOptions: number[];
  }[];
  dateFilters: {
    filterCode: DateFilterCode;
    selectedDate: string;
  }[];
}


export class LocalStorageCarFilter{

  private static  filterData: Record<number, FilterOption> = localStorage.getItem(StorageKey[StorageKey.FILTER_DATA]) != null? JSON.parse(localStorage.getItem(StorageKey[StorageKey.FILTER_DATA]) as string) : {};

  static getFilterDate(): Record<number, FilterOption> {
    return LocalStorageCarFilter.filterData
  }
  static setFilterDataToLocalStorage():void {
    localStorage.setItem(StorageKey[StorageKey.FILTER_DATA], JSON.stringify(LocalStorageCarFilter.filterData));
  }

  static addCarToFilterData(carId: number) {
    if (!LocalStorageCarFilter.filterData[carId]) {
      LocalStorageCarFilter.filterData[carId] = { selectFilters: [], dateFilters: [] };
    }
    LocalStorageCarFilter.setFilterDataToLocalStorage();
  }

  static updateSelectedDate(
      carId: number,
      dateFilterCode: DateFilterCode,
      date: string,
  ) {
    LocalStorageCarFilter.filterData[carId].dateFilters.forEach((dateFilter) =>
        dateFilter.filterCode === dateFilterCode
            ? (dateFilter.selectedDate = date)
            : dateFilter,
    );
    LocalStorageCarFilter.setFilterDataToLocalStorage();
  }

  static getSelectedDate(
      carId: number,
      dateFilterCode: DateFilterCode,
  ): string {
    const dateFilter:
        | { filterCode: DateFilterCode; selectedDate: string }
        | undefined = LocalStorageCarFilter.filterData[carId].dateFilters.find(
        (dateFilter) => dateFilter.filterCode === dateFilterCode,
    );
    if (!dateFilter) {
      LocalStorageCarFilter.filterData[carId].dateFilters.push({
        filterCode: dateFilterCode,
        selectedDate: "",
      });
      LocalStorageCarFilter.setFilterDataToLocalStorage();
      return "";
    }
    return dateFilter.selectedDate;
  }

  static updateSelectedData(
      carId: number,
      selectFilterCode: SelectFilterCode,
      selectedOptionIds: number[],
  ) {
    LocalStorageCarFilter.filterData[carId].selectFilters.forEach((selectFilter) =>
        selectFilter.filterCode === selectFilterCode
            ? (selectFilter.selectedOptions = selectedOptionIds)
            : selectFilter,
    );
    LocalStorageCarFilter.setFilterDataToLocalStorage();
  }

  static getSelectedData(
      carId: number,
      selectFilterCode: SelectFilterCode,
  ): number[] {
    const selectedFilter:
        | { filterCode: SelectFilterCode; selectedOptions: number[] }
        | undefined = LocalStorageCarFilter.filterData[carId].selectFilters.find(
        (selectFilter) => selectFilter.filterCode === selectFilterCode,
    );
    if (!selectedFilter) {
      LocalStorageCarFilter.filterData[carId].selectFilters.push({
        filterCode: selectFilterCode,
        selectedOptions: [],
      });
      LocalStorageCarFilter.setFilterDataToLocalStorage();
      return [];
    }
    return selectedFilter.selectedOptions;
  }
}


