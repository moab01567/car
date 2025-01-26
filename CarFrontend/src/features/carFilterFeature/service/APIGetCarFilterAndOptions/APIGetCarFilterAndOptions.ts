import {SelectFilterCode} from "../../Enum";
import {SelectFilterDTOAndMapper} from "./SelectFilterDTOAndMapper";
import {REST_API_URL} from "../../../../../env";


export  async function  APIGetCarFilterAndOptions(
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
