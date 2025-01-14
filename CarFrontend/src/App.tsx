import React from 'react'
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import {MainPage} from "./pages/MainPage";


function App() {

  return <BrowserRouter>
    <Routes>
        <Route path="/main" element={<MainPage />} />
        <Route path="*" element={<Navigate to={"/main"}/>} />
    </Routes>
  </BrowserRouter>

}

export default App
