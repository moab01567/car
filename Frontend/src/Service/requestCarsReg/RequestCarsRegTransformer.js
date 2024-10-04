import {RequestCarsRegBySelectionsApi} from "./RequestCarsRegBySelectionsApi.js";
import {RequestCarsRegByTlfApi} from "./RequestCarsRegByTlfApi.js";
import {RequestCarsRegByRegNumberApi} from "./RequestCarsRegByRegNumberApi.js";


export async function RequestCarsRegTransformer(selectedFilterOptions){

    if (selectedFilterOptions.reg !==""){
        return await RequestCarsRegByRegNumberApi(selectedFilterOptions)
    }
    if (selectedFilterOptions.tlf !==""){
        return await RequestCarsRegByTlfApi(selectedFilterOptions)
    }

    return await RequestCarsRegBySelectionsApi(selectedFilterOptions)
}