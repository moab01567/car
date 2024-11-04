import { TOKEN_NAME } from "../ApiInterface.ts";

export async function AuthValidator() {
  const requestOptions = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${sessionStorage.getItem(TOKEN_NAME)}`,
    },
  };

  const request: Request = new Request(
    "http://localhost:8080/auth/validate/token",
    requestOptions,
  );

  return await fetch(request);
}
