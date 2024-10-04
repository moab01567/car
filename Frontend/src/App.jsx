import React from 'react';
import { LoginPage } from "./pages/loginPage/LoginPage";
import "./style.css";
import { MainPage } from "./pages/mainPage/MainPage";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import { PageAuthenticator } from "./components/pageAuthenticator/PageAuthenticator";

export function App() {
    return (
        <Router>
            <Routes>
                <Route path="/login" element={<LoginPage />} />
                <Route path="/main" element={<PageAuthenticator tryPage={<MainPage />} />} />
                <Route path="*" element={<Navigate to={"/login"}/>} />
            </Routes>
        </Router>
    );
}
