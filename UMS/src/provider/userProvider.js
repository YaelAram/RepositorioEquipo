const url = 'http://localhost:8787/api/usuarios/';

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

export const getAllUsers = async ( token ) => {
  const resp = await fetch( url, {
    method: 'GET',
    headers: { token }
  } );

  const data = await resp.json();
  
  return {
    ok: resp.ok,
    data
  };
};

export const changeUserRol = async ( token, userId, rol ) => {
  const resp = await fetch( `${ url }${ userId }`, {
    method: 'PATCH',
    headers: {
      'content-type': 'application/json',
      token
    },
    body: JSON.stringify( { rol } )
  } );

  const data = await resp.json();

  return {
    ok: resp.ok,
    data
  };
};

export const deleteUser = async ( token, userId ) => {
  const resp = await fetch( `${ url }${ userId }`, {
    method: 'DELETE',
    headers: { token }
  } );

  const data = await resp.json();

  return {
    ok: resp.ok,
    data
  };
};
