import {APIPostCarFilterAndOptionsDTO} from "./SelectedFilterOptionDTOAndMapper";
import {SelectFilterDTOAndMapper} from "../APIGetCarFilterAndOptions/SelectFilterDTOAndMapper";
import {REST_API_URL} from "../../../../../env";


export  async function APIPostCarFilterAndOptions(APIPostCarFilterAndOptionsDTO:APIPostCarFilterAndOptionsDTO): Promise<SelectFilterDTOAndMapper>{
    const response = await fetch(
        `${REST_API_URL}/car/filter/options`,{
            method:"POST",
            headers:{
                "Content-Type":"application/json"},
            body: JSON.stringify(APIPostCarFilterAndOptionsDTO)
        }
    );

    if (response.ok) {
        return await response.json();
    } else throw Error("something went wrong");
}