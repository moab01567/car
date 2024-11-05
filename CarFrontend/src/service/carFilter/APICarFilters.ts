import { ResCarFilter, REST_API_URL, TOKEN_NAME } from "../ApiInterface.ts";

export async function APIGetAllCarFilters(
  urlPath: string,
): Promise<ResCarFilter[]> {
  const response = await fetch(REST_API_URL + urlPath, {
    method: "Get",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${sessionStorage.getItem(TOKEN_NAME)}`,
    },
  });
  return response.json();
}
