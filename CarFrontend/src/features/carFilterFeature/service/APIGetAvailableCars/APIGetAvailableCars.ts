import {CarDTO} from "./CarDTO";
import {REST_API_URL} from "../../../../../env";

 export async function  APIGetAvailableCars(): Promise<CarDTO[]> {
     const response = await fetch(REST_API_URL + "/car/filter/available/cars");
     if (response.ok) {
         return await response.json();
     } else throw Error("something went wrong");
 }