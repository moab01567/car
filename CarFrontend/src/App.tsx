import "./style.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login } from "./components/page/Login.tsx";
import { useState } from "react";
import { PrivateRouter } from "./components/page/PrivateRouter.tsx";
import { Main } from "./components/page/Main.tsx";

function App() {
  const [authenticated, setAuthenticated] = useState<boolean | null>(null);

  function setAuthStatus(status: null | boolean) {
    setAuthenticated(status);
  }

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" index element={<Login />} />
        <Route path="/*" element={<Login />} />
        <Route
          path="/main"
          element={
            authenticated ? (
              <Main />
            ) : (
              <PrivateRouter setAuthStatus={setAuthStatus} />
            )
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
