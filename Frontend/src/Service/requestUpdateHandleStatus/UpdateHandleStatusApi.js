import {REST_API_URL} from "../../config.js";


export async function UpdateHandleStatusApi(updateType,carId,handleStatusId){
    const request = new Request(`${REST_API_URL}/api/car/update/carInfo?carId=${carId}&value=${handleStatusId}&updateType=${updateType}`,{
        method:"put",
        headers:{
            "Content-Type":"application/json",
            "Authorization":`Bearer ${sessionStorage.getItem("AMS Token")}`
        }}
    )
    try{
        const response = await fetch(request);

        if (!response.ok){
            console.log(await response.json())
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return await response.json();
    }catch (error){
        console.error('Feil under API-kall:', error);
        return null;

    }
}