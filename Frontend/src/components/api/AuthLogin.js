import {REST_API_URL} from "../../config.js";


export async function AuthLogin(username, password){
    const request = new Request(REST_API_URL+"/auth/login", {
        method:"POST",
        headers: {'Content-Type': 'application/json'},
        body:JSON.stringify({username: username, password: password})});

    return await fetch(request);
}