import { useContext } from "react";

import { UserContext } from "../context/UserContext";

import { changeUserRol, deleteUser } from "../provider";
import { errorAlert, successAlert } from "../alerts";

export const useUserItem = ( id, deleteUserUI, updateUserUI ) => {
  const { user } = useContext( UserContext );

  const handleDelete = async () => {
    const { ok, data } = await deleteUser( user?.id, id );

    if( ok ) {
      deleteUserUI( id );
      successAlert( '¡Exito!', `El usuario ${ data?.nombre } ha sido eliminado con exito` );
    }
    else errorAlert( '¡Error!', `Lo sentimos, el usuario ${ data?.nombre } no pudo ser eliminado` );
  };

  const handleRolChanged = async ( { target } ) => {
    const { ok, data } = await changeUserRol( user?.id, id, target.value );
    if( ok ) {
      updateUserUI( id, data?.rol );
      successAlert( '¡Exito!', `El usuario ${ data?.nombre } ha sido actualizado con exito` );
    }
    else errorAlert( '¡Error!', `Lo sentimos, el usuario ${ data?.nombre } no pudo ser actualizado` );
  };

  return {
    handleDelete,
    handleRolChanged
  };
};
