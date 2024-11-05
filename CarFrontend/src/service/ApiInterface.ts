export const TOKEN_NAME: string = "AR_token";
export const REST_API_URL: string = import.meta.env.VITE_REST_API_URL;
interface FilterOption {
  carType: FilterOptionDetails;
  carFuel: FilterOptionDetails;
  carStatus: FilterOptionDetails;
  handleStatus: FilterOptionDetails;
  transmission: FilterOptionDetails;
  carSeats: FilterOptionDetails;
}

interface FilterOptionDetails {
  url: string;
}

export const GET_CAR_OPTION_URL_STRUCTURE: FilterOption = {
  carType: { url: "/api/car/filter-options/v2?filterType=carType" },
  carFuel: { url: "/api/car/filter-options/v2?filterType=carFuel" },
  carStatus: { url: "/api/car/filter-options/v2?filterType=carStatus" },
  handleStatus: { url: "/api/car/filter-options/v2?filterType=handleStatus" },
  transmission: { url: "/api/car/filter-options/v2?filterType=transmission" },
  carSeats: { url: "/api/car/filter-options/v2?filterType=carSeats" },
};

export interface ResMassage {
  massage: string;
}
export interface ResToken {
  token: string;
}

export interface ResCarFilter {
  optionId: number;
  optionName: string;
}

export interface CarFilterOption {
  carSeats: number[];
  fuelId: number[];
  carStatusId: number[];
  handleStatus: number[];
  transmission: number[];
}

export interface ReqCarFilterOptionStructure {
  1: CarFilterOption[];
}
