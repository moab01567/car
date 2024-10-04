

export async function FilterOptionRequest(filterOption){
    console.log(filterOption)
    const request = new Request("/api/car/selected-options",{
        method:"POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${sessionStorage.getItem("AMS Token")}`
        },
        body: JSON.stringify(filterOption)
    });

        const response= await  fetch(request);

        if (!response) {
            throw Error;
        }
        return await response.json()


}