

export async function ApiCarOwnerDelete(carID, tlf){
    const request = new Request(`/api/car/ownerHandler/deleteOwner?carId=${carID}&tlf=${tlf}`,{
        method:"DELETE",
        headers: {
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${sessionStorage.getItem("AMS Token")}`
        }
    })

    const response= await fetch(request);
    return response;

}