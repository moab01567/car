
export async function ApiAuthLogin(username: string, password: string){

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: username, password:password})
    };

    const request:Request =  new Request("http://localhost:8080/auth/login",requestOptions)

    return await fetch(request)
}