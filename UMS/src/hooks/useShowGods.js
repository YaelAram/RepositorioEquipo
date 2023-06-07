import { useEffect, useState } from "react";

import { getAllGods } from "../provider";

export const useShowGods = () => {
  const [ gods, setGods ] = useState( [] );
  const [ isLoading, setIsLoading ] = useState( false );

  useEffect( () => {
    const getGods = async () => {
      setIsLoading( true );
      const data = await getAllGods();
      setGods( data );
      setIsLoading( false );
    };
    getGods();
  }, [] );
  
  return {
    isLoading,
    gods
  }
};
