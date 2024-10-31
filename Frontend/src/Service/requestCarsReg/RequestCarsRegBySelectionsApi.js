import {REST_API_URL} from "../../config.js";

export async function RequestCarsRegBySelectionsApi(selectedFilterOptions){
    const url = `${REST_API_URL}/api/car/selected-options/v2?carTypesIds=${selectedFilterOptions.carType.toString()}&carFuelIds=${selectedFilterOptions.carFuel.toString()}&carStatusIds=${selectedFilterOptions.carStatus.toString()}&handleStatusIds=${selectedFilterOptions.handleStatus.toString()}&carSeatsIds=${selectedFilterOptions.carSeats.toString()}&transmissionIds=${selectedFilterOptions.carTransmission.toString()}&carFrom=${selectedFilterOptions.carFrom}&carTo=${selectedFilterOptions.carTo}&euFrom=${selectedFilterOptions.euFrom}&euTo=${selectedFilterOptions.euTo}`

    const request = new Request(url, {
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
        return [];
    }


}