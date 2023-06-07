import { useContext } from "react";

import { useNavigate } from "react-router-dom";

import { UserContext } from "../context/UserContext";

import { deleteGod } from '../provider';
import { errorAlert, successAlert } from '../alerts';

export const useEditGod = ( godId ) => {
  const { user } = useContext( UserContext );
  const navigate = useNavigate();

  const handleDelete = async () => {
    const { ok, data } = await deleteGod( godId, user?.id );

    if( ok ) {
      successAlert( '¡Exito!', `El dios ${ data.nombre } ha sido borrado con exito` );
      navigate( '/', { replace: true } );
    }
    else errorAlert( 'Error', 'Lo siento, el dios no se pudo borrar' );
  };

  return {
    handleDelete
  };
};
