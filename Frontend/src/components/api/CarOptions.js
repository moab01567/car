
export async function CarOptions() {
    const request = new Request("/api/car/filter-options", {
        method: "GET",
        headers: {
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${sessionStorage.getItem("AMS Token")}`
        }
    });

    const response = await fetch(request)
    console.log(response.status)
    return response;
}