import { useContext } from 'react';

import { Navigate, Route, Routes } from "react-router-dom";

import { UserContext } from "../context/UserContext";
import { CreateGod, ShowGods, God, LogIn, SignIn } from "../pages";
import { NavBar } from "../components/NavBar";

export function AppRouter() {
  const { isLogged } = useContext( UserContext );

  return (
    <>
      <NavBar />
      {
        (isLogged) ? (
          <Routes>
            <Route path="/" element={ <ShowGods /> }/>
            <Route path="/crear" element={ <CreateGod /> }/>
            <Route path="/:id" element={ <God /> }/>
            <Route path="/*" element={ <Navigate to="/" /> }/>
          </Routes>
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
