



export async function UpdateFollowUpApi(carId, followUpdate){
    const request = new Request(`/api/car/update/followUpDate?carId=${carId}&followUpDate=${followUpdate}`,{
        method:"PUT",
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