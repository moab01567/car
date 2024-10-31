import {REST_API_URL} from "../../config.js";


export async function RequestRemoveOwnerApi(carId,tlf){
    const request = new Request(`${REST_API_URL}/api/car/owner/remove?carId=${carId}&tlf=${tlf}`,{
        method:"DELETE",
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