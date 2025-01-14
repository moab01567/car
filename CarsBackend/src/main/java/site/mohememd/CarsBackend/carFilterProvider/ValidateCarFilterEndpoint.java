package site.mohememd.CarsBackend.carFilterProvider;

import site.mohememd.CarsBackend.exceptions.FilterNotFound;

public  class  ValidateCarFilterEndpoint {

    public static void validateCarFilterCode(String filterCode) {
        try{
            FilterCode.valueOf(filterCode);
        }catch (Exception e){
            throw new FilterNotFound(filterCode);
        }
    }


}
