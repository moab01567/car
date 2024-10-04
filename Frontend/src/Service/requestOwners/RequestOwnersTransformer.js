import {RequestOwnersApi} from "./RequestOwnersApi";


export async function RequestOwnersTransformer(carId){
    return await RequestOwnersApi(carId)
}