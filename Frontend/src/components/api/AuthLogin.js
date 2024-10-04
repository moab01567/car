

export async function AuthLogin(username, password){
    const request = new Request("/auth/login", {
        method:"POST",
        headers: {'Content-Type': 'application/json'},
        body:JSON.stringify({username: username, password: password})});

    return await fetch(request);
}