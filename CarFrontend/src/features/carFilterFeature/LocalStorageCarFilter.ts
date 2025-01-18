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

function getFilterDataKey(){
  return StorageKey[StorageKey.FILTER_DATA]
}

const filterData: Record<number, FilterOption> =
  localStorage.getItem(getFilterDataKey()) != null
    ? JSON.parse(
        localStorage.getItem(getFilterDataKey()) as string,
      )
    : {};

function setFilterDataToLocalStorage() {
  localStorage.setItem(
    getFilterDataKey(),
    JSON.stringify(filterData),
  );
}

export function addCarToFilterData(carId: number) {
  if (!filterData[carId]) {
    filterData[carId] = { selectFilters: [], dateFilters: [] };
  }
  setFilterDataToLocalStorage();
}

export function updateSelectedDate(
  carId: number,
  dateFilterCode: DateFilterCode,
  date: string,
) {
  filterData[carId].dateFilters.forEach((dateFilter) =>
    dateFilter.filterCode === dateFilterCode
      ? (dateFilter.selectedDate = date)
      : dateFilter,
  );
  setFilterDataToLocalStorage();
}

export function getSelectedDate(
  carId: number,
  dateFilterCode: DateFilterCode,
): string {
  const dateFilter:
    | { filterCode: DateFilterCode; selectedDate: string }
    | undefined = filterData[carId].dateFilters.find(
    (dateFilter) => dateFilter.filterCode === dateFilterCode,
  );

  if (!dateFilter) {
    filterData[carId].dateFilters.push({
      filterCode: dateFilterCode,
      selectedDate: "",
    });
    setFilterDataToLocalStorage();
    return "";
  }
  return dateFilter.selectedDate;
}

export function updateSelectedData(
  carId: number,
  selectFilterCode: SelectFilterCode,
  selectedOptionIds: number[],
) {
  filterData[carId].selectFilters.forEach((selectFilter) =>
    selectFilter.filterCode === selectFilterCode
      ? (selectFilter.selectedOptions = selectedOptionIds)
      : selectFilter,
  );
  setFilterDataToLocalStorage();
}

export function getSelectedData(
  carId: number,
  selectFilterCode: SelectFilterCode,
): number[] {
  const selectedFilter:
    | { filterCode: SelectFilterCode; selectedOptions: number[] }
    | undefined = filterData[carId].selectFilters.find(
    (selectFilter) => selectFilter.filterCode === selectFilterCode,
  );
  if (!selectedFilter) {
    filterData[carId].selectFilters.push({
      filterCode: selectFilterCode,
      selectedOptions: [],
    });
    setFilterDataToLocalStorage();
    return [];
  }
  return selectedFilter.selectedOptions;
}
