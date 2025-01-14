import {SelectFilterCode} from "../Enum";
import {CarDTO, SelectFilterDTO} from "../DTO/AllCarFilterDTOs";
import {REST_API_URL} from "../../../../env";

export async function APIGetAvailableCars() : Promise<CarDTO[]>{
    const response = await fetch(REST_API_URL+"/car/filter/available/cars")
    if( response.ok){
        return await response.json()
    }else throw Error("something went wrong")
}



export async function APIGetCarFilterAndOptions(carTypeId:number,selectFilterCode: SelectFilterCode ) : Promise<SelectFilterDTO>{
    const response = await fetch(`http://localhost:8080/car/filter/${carTypeId}/${SelectFilterCode[selectFilterCode]}`)
    if( response.ok){
        return await response.json()
    }else throw Error("something went wrong")
}