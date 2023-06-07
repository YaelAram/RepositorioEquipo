import { useContext, useRef } from "react";
import { useNavigate } from "react-router-dom";

import { UserContext } from "../context/UserContext";

import { updateGod } from "../provider";
import { errorAlert, successAlert } from '../alerts';

export const useUpdateGod = ( id ) => {
  const nombreCampo = useRef();
  const epitetoCampo = useRef();
  const panteonCampo = useRef();
  const rolCampo = useRef();

  const { user } = useContext( UserContext );
  
  const navigate = useNavigate();


  const handleSubmit = async ( evt ) => {
    evt.preventDefault();

    const god = {
      nombre: nombreCampo.current.value,
      epiteto: epitetoCampo.current.value,
      panteon: panteonCampo.current.value,
      rol: rolCampo.current.value,
    };

    const { ok, data } = await updateGod( user.id, id, god );

    if( ok ) {
      successAlert( '¡Exito!', `El dios ${ data.nombre } ha sido actualizado con exito` );
      navigate( '/', { replace: true } );
    }
    else errorAlert( '¡Error!', 'Lo sentimos, el dios no pudo ser actualizado' );
  };

  return {
    nombreCampo,
    epitetoCampo,
    panteonCampo,
    rolCampo,
    handleSubmit
  };
};
