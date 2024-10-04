export async function FilterDataApi(filterType) {
    const request = new Request(`/api/car/filter-options/v2?filterType=${filterType}`, {
        method: "GET",  // Endret til GET hvis hensikten er å hente data
        headers: {
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${sessionStorage.getItem("AMS Token")}`
        }
    });

    try {
        const response = await fetch(request);

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        return await response.json();

    } catch (error) {
        console.error('Feil under API-kall:', error);
        return null;
    }
}
