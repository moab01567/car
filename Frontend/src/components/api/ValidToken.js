import {REST_API_URL} from "../../config.js";


export async function ValidToken(){
    const request = new Request(REST_API_URL+"/auth/validate/token", {
        method:"GET",
        headers: {'Content-Type': 'application/json',
                    "Authorization": `Bearer ${sessionStorage.getItem("AMS Token")}`}
        }
        )
    const response = await fetch(request)
    console.log(response.status)
    if (response.ok){
        console.log(await response.json())
    }
    return response.ok;


}