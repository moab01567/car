package site.mohememd.CarsBackend.carFilterProvider;

import site.mohememd.CarsBackend.carFilterProvider.enums.SelectorFilterCode;
import site.mohememd.CarsBackend.exceptions.FilterNotFound;

public  class  ValidateCarFilterEndpoint {

    public static void validateCarFilterCode(String filterCode) {
        try{
            SelectorFilterCode.valueOf(filterCode);
        }catch (Exception e){
            throw new FilterNotFound(filterCode);
        }
    }


}
