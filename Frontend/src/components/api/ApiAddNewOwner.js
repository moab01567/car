

export async function ApiAddNewOwner(carAndNewOwner){
    const request = new Request("/api/car/ownerHandler/addOwner",{
        method:"Post",
        headers: {
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${sessionStorage.getItem("AMS Token")}`
        },body: JSON.stringify(carAndNewOwner)
    })


    const response = await fetch(request)
    return response ;
}