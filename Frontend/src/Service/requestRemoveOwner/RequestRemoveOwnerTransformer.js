import {RequestRemoveOwnerApi} from "./RequestRemoveOwnerApi";


export async function RequestRemoveOwnerTransformer(carId,tlf){
    return await RequestRemoveOwnerApi(carId,tlf)
}