export const TOKEN_NAME: string = "AR_token";
export const GET_CAR_OPTION_URL: string = "/api/car/filter-options/v2";

export interface Massage {
  massage: string;
}
export interface Token {
  token: string;
}

export interface CarFilter {
  optionId: number;
  optionName: string;
}
