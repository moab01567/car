

export async function AddOwnerAPI(carId, tlf, name, place, contacted){
    const request = new Request(`/api/car/owner/add?carId=${carId}&ownerTlf=${tlf}&ownerName=${name}&place=${place}&contacted=${contacted}`,{
        method:"PUT",
        headers:{
            "Content-Type":"application/json",
            "Authorization":`Bearer ${sessionStorage.getItem("AMS Token")}`
        },body: JSON.stringify()}
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