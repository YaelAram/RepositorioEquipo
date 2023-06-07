import { NavLink } from "react-router-dom";

import { PlayerOptions } from "./PlayerOptions";

const activeClass = ( { isActive } ) => ( isActive ) ? "active" : undefined;

export function AdminOptions() {
  return (
    <>
      <li className="navbar-li">
        <NavLink to="/crear" className={ activeClass }>Crear Dios</NavLink>
      </li>
      <PlayerOptions />
    </>
  );
};
