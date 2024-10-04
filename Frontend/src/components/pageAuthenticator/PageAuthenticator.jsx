import React, {useMemo} from "react";
import { useEffect, useState } from "react";
import { ValidToken } from "../api/ValidToken";
import {Navigate, useNavigate} from "react-router-dom";

export  function PageAuthenticator({ tryPage }) {
    const navigate = useNavigate();
    const [isAuthenticated, setIsAuthenticated] = useState(null);

    useEffect(()=>{
        async function checkToken(){
            const result = await ValidToken();
            setIsAuthenticated(result);
        }
        checkToken()
    },[])

    if (isAuthenticated === null){
        return <>waiting on server</>;
    }

   return isAuthenticated ? tryPage: <Navigate to={"/login"}/>;
}
