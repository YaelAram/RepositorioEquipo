import { useContext } from "react";

import { NavLink } from "react-router-dom";

import { UserContext } from "../context/UserContext";

const activeClass = ( { isActive } ) => ( isActive ) ? "active" : undefined;

export function PlayerOptions() {
  const { logOutUser } = useContext( UserContext );

  return (
    <>
      <li className="navbar-li">
        <NavLink to="/" className={ activeClass }>Ver Dioses</NavLink>
      </li>
      <li className="navbar-li" onClick={ logOutUser }>
        Cerrar Sesion
      </li>
    </>
  );
};
