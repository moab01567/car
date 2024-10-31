import {REST_API_URL} from "../../config.js";

export async function CarOptions() {
    const request = new Request(REST_API_URL+"/api/car/filter-options", {
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