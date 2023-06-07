import { useState } from 'react';
import { UserContext } from './UserContext';

const initialState = {
  id: null,
  nombre: null,
  email: null,
  rol: 'GUEST'
};

export const UserProvider = ( { children } ) => {
  const { rol: storedRol, ...storedUser } = JSON.parse( localStorage.getItem( 'user' ) ) ?? initialState;

  const [ user, setUser ] = useState( storedUser );
  const [ rol, setRol ] = useState( storedRol );
  const [ isLogged, setLogged ] = useState( !!user.id );

  const updateUser = ( user ) => setUser( user );
  const forgetUser = () => setUser( initialState );

  const setNewRol = ( newRol ) => setRol( newRol );

  const logInUser = ( user ) => {
    updateUser( user );
    setNewRol( user?.rol ?? 'GEST' );
    setLogged( true );
  };

  const logOutUser = () => {
    localStorage.removeItem( 'user' );
    forgetUser();
    setNewRol( 'GUEST' );
    setLogged( false );
  };

  return (
      <UserContext.Provider value={ { 
        user, rol, isLogged, logInUser, logOutUser
        } }>
          { children }
      </UserContext.Provider>
  );
};
