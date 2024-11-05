import styleLogin from "./Login.module.css";
import { useState } from "react";
import { ApiAuthLogin } from "../../service/auth/AuthLogin.ts";
import { Massage, Token, TOKEN_NAME } from "../../service/ApiInterface.ts";
import { useNavigate } from "react-router-dom";

type AuthRes = Massage & Token;

export function Login() {
  const [username, setUsername] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const [failedLogin, setFailedLogin] = useState<boolean>(false);
  const navigate = useNavigate();

  async function handleSubmit(event: any) {
    event.preventDefault();
    const response: Response = await ApiAuthLogin(username, password);
    if (response.ok) {
      const data: AuthRes = await response.json();
      sessionStorage.setItem(TOKEN_NAME, data.token);
      navigate("/main");
      setFailedLogin(false);
    } else {
      setFailedLogin(true);
    }
    console.log(sessionStorage.getItem(TOKEN_NAME));
  }

  return (
    <div className={styleLogin.div}>
      <form className={styleLogin.form} onSubmit={handleSubmit}>
        <h2>Abdulriza Transport</h2>
        {failedLogin ? <p>Wrong username or password</p> : <p></p>}
        <input
          onChange={(event) => setUsername(event.target.value)}
          placeholder="Username"
          className={styleLogin.items}
          type="text"
        />
        <input
          onChange={(event) => setPassword(event.target.value)}
          placeholder="passowrd"
          className={styleLogin.items}
          type="password"
        />
        <input value="login" className={styleLogin.items} type="submit" />
      </form>
    </div>
  );
}
