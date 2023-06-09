import { useContext, useEffect, useState } from "react";

import { UserContext } from "../context/UserContext";

import { getAllUsers } from '../provider';
import { errorAlert } from '../alerts';

export const useUserManager = () => {
  const [ users, setUsers ] = useState( [] );
  const { user } = useContext( UserContext );

  useEffect( () => {
    const getUsers = async () => {
      const { ok, data } = await getAllUsers( user?.id );
      if( ok ) setUsers( data );
      else errorAlert( '¡Error!', 'Lo sentimos, hubo un error al obtener la lista de usuarios' );
    };

    getUsers();
  }, [] );

  const deleteUserUI = ( id ) => {
    setUsers( ( currentUsers ) => currentUsers.filter( ( currentUser ) => currentUser?.id !== id ) );
  };

  const updateUserUI = ( id, rol ) => {
    setUsers( ( currentUsers ) => currentUsers.map( ( currentUser ) => {
      if( currentUser?.id === id ) {
        currentUser.rol = rol;
        return currentUser;
      }
      else return currentUser;
    } ) );
  };
  
  return {
    users,
    deleteUserUI,
    updateUserUI
  };
};
