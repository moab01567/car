

export async function ValidToken(){
    const request = new Request("/auth/validate/token", {
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