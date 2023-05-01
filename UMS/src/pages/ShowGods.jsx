import { useEffect, useState } from "react";
import { GodList } from '../components/GodList'

const url = 'http://localhost:8081/api/dioses/';

export function ShowGods() {
  const [ gods, setGods ] = useState( [] );

  useEffect( () => {
    const getGods = async () => {
      const resp = await fetch( url, { method: 'GET' } );
      let data = await resp.json();
      data = data.filter( ( god ) => god.active );
      data = data.sort( ( god1, god2 ) => {
        const name1 = god1.nombre.toUpperCase();
        const name2 = god2.nombre.toUpperCase();
        return ( name1 < name2 ) ? -1 : ( name1 > name2 ) ? 1 : 0;
      } );
      setGods( data );
    };

    getGods();
  }, [] );

  return (
    <section>
      <h1>Dioses</h1>
      <GodList gods={ gods } />
    </section>
  );
}
