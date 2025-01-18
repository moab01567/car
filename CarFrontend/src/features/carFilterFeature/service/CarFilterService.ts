import { SelectFilterCode } from "../Enum";
import { REST_API_URL } from "../../../../env";
import {SelectFilterDTOAndMapper} from "../DTO/SelectFilterDTOAndMapper";
import {CarDTO} from "../DTO/CarDTO";
import {SelectedFilterOptionDTO} from "../DTO/SelectedFilterOptionDTOAndMapper";

export async function APIGetAvailableCars(): Promise<CarDTO[]> {
  const response = await fetch(REST_API_URL + "/car/filter/available/cars");
  if (response.ok) {
    return await response.json();
  } else throw Error("something went wrong");
}

export async function APIGetCarFilterAndOptions(
  carTypeId: number,
  selectFilterCode: SelectFilterCode,
): Promise<SelectFilterDTOAndMapper> {
  const response = await fetch(
    `${REST_API_URL}/car/filter/${carTypeId}/${SelectFilterCode[selectFilterCode]}`,
  );
  if (response.ok) {
    return await response.json();
  } else throw Error("something went wrong");
}

export async function APIPostCarFilterAndOptions(selectedFilterOptionDTO:SelectedFilterOptionDTO[]): Promise<SelectFilterDTOAndMapper> {
  const response = await fetch(
      `${REST_API_URL}/car/filter/options`,{
        method:"POST",
        headers:{
          "Content-Type":"application/json"},
        body: JSON.stringify(selectedFilterOptionDTO)
      }
  );

  if (response.ok) {
    return await response.json();
  } else throw Error("something went wrong");
}
