import {REST_API_URL} from "../../config.js";


export async function ApiCarOwnerDelete(carID, tlf){
    const request = new Request(`${REST_API_URL}/api/car/ownerHandler/deleteOwner?carId=${carID}&tlf=${tlf}`,{
        method:"DELETE",
        headers: {
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${sessionStorage.getItem("AMS Token")}`
        }
    })

    const response= await fetch(request);
    return response;

}