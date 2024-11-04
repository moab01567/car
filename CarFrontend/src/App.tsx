import "./style.css"
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Login} from "./components/page/Login.tsx";
import {useEffect, useState} from "react";
import {AuthValidator} from "./service/auth/AuthValidator.ts";
import {CarFilter} from "./components/carFilter/CarFilter.tsx";
import {LoadingIndicator} from "./components/loading/LoadingIndicator.tsx";


function App() {
    const [authenticated, setAuthenticated] = useState<boolean | null>(null)

    useEffect(() => {
        async function isAuthenticated(){
             const response:Response = await AuthValidator()
            if(response.ok){
                console.log(await response.json())
                setAuthenticated(true)
            }
        }
        isAuthenticated()
    }, []);

    if (authenticated==null){
        return <LoadingIndicator/>
    }


  return (
        <BrowserRouter>
            <Routes>
                <Route path="/page/loading" element={<LoadingIndicator/>}/>
                <Route path="/login" index element={<Login/>} />
                <Route path="/*" element={(authenticated? <CarFilter/> : <Login/>)}/>
                <Route path="/main" element={authenticated? <CarFilter/> : <Login/>} />
            </Routes>
        </BrowserRouter>
        )
}

export default App
