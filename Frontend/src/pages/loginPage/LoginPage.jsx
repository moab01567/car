
import React, {useState} from "react";
import LoginPageStyle from "./LoginPage.module.css";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import {AuthLogin} from "../../components/api/AuthLogin";
import {Alert} from "@mui/material";
import {useNavigate} from "react-router-dom";

export function LoginPage(){
    const navigate = useNavigate()
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [errorText, setErrorText] = useState("")
    const [errorIcon, setErrorIcon] = useState("")
    const [displayError, setDisplayError] = useState(false)
    async function handleSubmit(event) {
        event.preventDefault();
        const response = await AuthLogin(username, password);
        const data = await response.json();

        if (response.ok){
            console.log("dette er i login page")
            console.log(data)
            sessionStorage.setItem("AMS Token", data.token)

            navigate("/main")
        }else{
            setErrorIcon("error")
            setErrorText(data.message)
            setDisplayError(true)
        }

    }

    return <div className={LoginPageStyle.page}>

        <form onSubmit={handleSubmit}  className={LoginPageStyle.loginForm}>
            <h1>Abdul-Riza Transport </h1>
            <Alert severity={errorIcon}>
                {errorText}
            </Alert>
            <TextField  error={displayError} onChange={(event) => setUsername(event.target.value)}
                       label="username" variant="outlined" className={LoginPageStyle.input}/>
            <TextField error={displayError} value={password} onChange={(event)=> setPassword(event.target.value)}
                       label="password" variant="outlined" type="password" className={LoginPageStyle.input} />
            <Button  variant="outlined" type="submit">Login</Button>
        </form>

    </div>
}
