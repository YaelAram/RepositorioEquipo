import { useContext } from 'react';

import { Navigate, Route, Routes } from "react-router-dom";

import { UserContext } from "../context/UserContext";
import { CreateGod, ShowGods, God, LogIn, SignIn, UserManager } from "../pages";
import { NavBar } from "../components/NavBar";

export function AppRouter() {
  const { isLogged, rol } = useContext( UserContext );

  return (
    <>
      {
        ( isLogged ) ? (
          ( rol === 'ADMIN' ) ? (
            <>
              <NavBar />
              <Routes>
                <Route path="/" element={ <ShowGods /> }/>
                <Route path="/crear" element={ <CreateGod /> }/>
                <Route path="/usuarios" element={ <UserManager /> }/>
                <Route path="/:id" element={ <God /> }/>
                <Route path="/*" element={ <Navigate to="/" /> }/>
              </Routes>
            </>
          ) : (
            <>
              <NavBar />
              <Routes>
                <Route path="/" element={ <ShowGods /> }/>
                <Route path="/:id" element={ <God /> }/>
                <Route path="/*" element={ <Navigate to="/" /> }/>
              </Routes>
            </>
          )
        ) : (
          <Routes>
            <Route path="/" element={ <LogIn /> }/>
            <Route path="/registro" element={ <SignIn /> }/>
            <Route path="/*" element={ <Navigate to="/" /> }/>
          </Routes>
        )
      }
    </>
  );
}
