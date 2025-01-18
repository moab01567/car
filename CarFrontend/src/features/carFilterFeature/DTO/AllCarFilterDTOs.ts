import { DateFilterCode, SelectFilterCode } from "../Enum";

export interface CarDTO {
  carId: number;
  carName: string;
}

export interface SelectFilterDTO {
  selectFilterCode: string;
  filterName: string;
  filterOptionDTOS: [
    {
      optionId: number;
      option: string;
    },
  ];
}

export interface SelectedFilterOptionDTO {
  carId: number;
  selectFilters: {
    filterCode: SelectFilterCode;
    selectedOptions: number[];
  }[];
  dateFilters: {
    filterCode: DateFilterCode;
    selectedDate: string;
  }[];
}
