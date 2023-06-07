import { useContext, useEffect, useState } from "react";

import { useParams } from "react-router-dom";

import { UserContext } from "../context/UserContext";

import { getGodByID } from "../provider";

export const useGod = () => {
  const { rol } = useContext( UserContext );
  const [ god, setGod ] = useState( {} );
  const { img, nombre, panteon } = god;

  const { id } = useParams();

  useEffect( () => {
    const getGod = async () => {
      const data = await getGodByID( id );
      setGod( data );
    };

    getGod();
  }, [] );

  return {
    rol,
    god,
    img,
    alt: `${ nombre } ${ panteon } god`
  };
};
