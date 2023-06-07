const url = 'http://localhost:8081/api/usuarios/';

export const createUser = async ( form ) => {
  const resp = await fetch( url, {
    method: 'POST',
    headers: { 'content-type': 'application/json' },
    body: JSON.stringify( form )
  } );

  const data = await resp.json();

  return {
    ok: resp.ok,
    data
  };
};

export const logIn = async ( form ) => {
  const resp = await fetch( `${ url }auth`, {
    method: 'POST',
    headers: { 'content-type': 'application/json' },
    body: JSON.stringify( form )
  } );

  const data = await resp.json();

  return {
    ok: resp.ok,
    data
  }
};

export const getAllUsers = async () => {
  
};

export const changeUserRol = async () => {
  
};

export const deleteUser = async () => {
  
};
