const url = 'http://localhost:8787/api/dioses/';

export const createGod = async ( form, token ) => {
  const resp = await fetch( url, { 
    method: 'POST', 
    headers: { 
      'content-type': 'application/json',
      token
    },
    body: JSON.stringify( form )
  } );

  const { nombre } = await resp.json();

  return {
    ok: resp.ok,
    nombre
  };
};

export const getAllGods = async () => {
  const resp = await fetch( url, { method: 'GET' } );
  let data = await resp.json();
  data = data.filter( ( god ) => god.active );
  data = data.sort( ( god1, god2 ) => {
    const name1 = god1.nombre.toUpperCase();
    const name2 = god2.nombre.toUpperCase();
    return ( name1 < name2 ) ? -1 : ( name1 > name2 ) ? 1 : 0;
  } );

  return data;
};

export const getGodByID = async ( id ) => {
  const resp = await fetch( `${ url }${ id }`, { method: 'GET' } );
  const data = await resp.json();

  return data;
};

export const updateGod = async ( token, id, updatedGod ) => {
  const resp = await fetch( `${ url }${ id }`, { 
    method: 'PATCH', 
    headers:{
      'content-type': 'application/json',
      token
    },
    body: JSON.stringify( updatedGod )
  } );
  const data = await resp.json();

  return { 
    ok: resp.ok,
    data
  };
};

export const deleteGod = async ( id, token ) => {
  const resp = await fetch( `${ url }${ id }`, { 
    method: 'DELETE',
    headers: {
      'content-type': 'application/json',
      token
    }
   } );
  const data = await resp.json();

  return {
    ok: resp.ok,
    data
  };
};
