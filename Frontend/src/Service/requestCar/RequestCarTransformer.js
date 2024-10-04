import {RequestCarApi} from "./RequestCarApi";


export async function RequestCarTransformer(carId){

    return await RequestCarApi(carId);
}