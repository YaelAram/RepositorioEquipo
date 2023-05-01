import { Route, Routes } from "react-router-dom";

import { CreateGod, ShowGods, God } from "../pages";
import { NavBar } from "../components/NavBar";

export function AppRouter() {
  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={ <ShowGods /> }/>
        <Route path="/crear" element={ <CreateGod /> }/>
        <Route path="/:id" element={ <God /> }/>
      </Routes>
    </>
  );
}
