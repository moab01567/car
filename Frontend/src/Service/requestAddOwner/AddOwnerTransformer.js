import {AddOwnerAPI} from "./AddOwnerAPI";


export async function AddOwnerTransformer(carId, tlf, name, place, contacted){
    return await AddOwnerAPI(carId, tlf, name, place, contacted)


}