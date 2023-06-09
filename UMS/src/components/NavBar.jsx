import { useContext } from "react";

import { UserContext } from "../context/UserContext";
import { AdminOptions } from "./AdminOptions";
import { PlayerOptions } from "./PlayerOptions";
import { GuestOptions } from "./GuestOptions";

export function NavBar() {
  const { user, rol, isLogged } = useContext( UserContext );

  return (
    <nav className="grid">
      <p className="user-name">{ user.nombre?.toUpperCase() }</p>
      <ul className="navbar-ul">
        {
          ( !isLogged ) ? <GuestOptions /> : ( ( rol === 'ADMIN' ) ? <AdminOptions /> : <PlayerOptions /> )
        }
      </ul>
    </nav>
  );
}
