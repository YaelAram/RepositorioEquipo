import { NavLink } from "react-router-dom";

const activeClass = ( { isActive } ) => ( isActive ) ? "active" : undefined;

export function GuestOptions() {
  return (
    <>
      <li className="navbar-li">
        <NavLink to="/" className={ activeClass }>Iniciar Sesion</NavLink>
      </li>
      <li className="navbar-li">
        <NavLink to="/registro" className={ activeClass }>Registro</NavLink>
      </li>
    </>
  );
};
