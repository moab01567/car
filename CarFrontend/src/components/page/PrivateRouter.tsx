import { LoadingIndicator } from "../loading/LoadingIndicator.tsx";
import { useEffect } from "react";
import { AuthValidator } from "../../service/auth/AuthValidator.ts";

interface Props {
  setAuthStatus: (status: null | boolean) => void;
}

export function PrivateRouter({ setAuthStatus }: Props) {
  useEffect(() => {
    isAuthenticated();
  }, []);

  async function isAuthenticated() {
    setAuthStatus(null);
    const response: Response = await AuthValidator();

    if (response.ok) {
      console.log(await response.json());
      setAuthStatus(true);
    } else {
      setAuthStatus(false);
    }
  }

  return <LoadingIndicator />;
}
