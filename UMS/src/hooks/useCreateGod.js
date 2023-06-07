import { useContext } from "react";

import { UserContext } from "../context/UserContext";

import { useForm } from "./useForm";

import { createGod } from "../provider";
import { errorAlert, successAlert } from "../alerts";

const formData = {
  img: '',
  nombre: '',
  epiteto: '',
  panteon: '',
  rol: ''
};

export const useCreateGod = () => {
  const { form, img, nombre, epiteto, panteon, rol, onInputChange, onReset } = useForm( formData );
  const { user } = useContext( UserContext );

  const handleSubmit = async ( evt ) => {
    evt.preventDefault();

    const { ok, nombre } = await createGod( form, user?.id );

    if( ok ) {
      successAlert( '¡Exito!', `El dios ${ nombre } ha sido creado con exito` );
      onReset();
    }
    else errorAlert( 'Error', `Lo sentimos, el dios ${ nombre } no pudo ser creado` );
  };

  return {
    img,
    nombre,
    epiteto,
    panteon,
    rol,
    onInputChange,
    handleSubmit
  };
};
