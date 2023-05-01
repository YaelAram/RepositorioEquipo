import { NavLink } from "react-router-dom";

const activeClass = ( { isActive } ) => ( isActive ) ? "active" : undefined;

export function NavBar() {

  return (
    <nav>
      <ul className="navbar-ul">
        <li className="navbar-li">
          <NavLink to="/" className={ activeClass }>Ver Dioses</NavLink>
        </li>
        <li className="navbar-li">
          <NavLink to="/crear" className={ activeClass }>Crear Dios</NavLink>
        </li>
      </ul>
    </nav>
  );
}
