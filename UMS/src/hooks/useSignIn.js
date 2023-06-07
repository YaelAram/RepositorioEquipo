import { useNavigate } from "react-router-dom";

import { useForm } from "./useForm";

import { createUser } from "../provider";
import { errorAlert, successAlert } from '../alerts';

const formData = {
  nombre: '',
  email: '',
  password: ''
};

export const useSignIn = () => {
  const { form, nombre, email, password, onInputChange, onReset } = useForm( formData );
  const navigate = useNavigate();

  const handleSubmit = async ( evt ) => {
    evt.preventDefault();

    const { ok, data } = await createUser( form );

    if( !ok ) errorAlert( 'Error', `Lo sentimos, el usuario ${ data.nombre } no pudo ser creado` );
    else{
      onReset();
      successAlert( 'Exito!', `El usuario ${ data.nombre } ha sido creado con exito` );
      navigate( '/', { replace: true } );
    }
  };

  return {
    handleSubmit,
    nombre,
    email,
    password,
    onInputChange
  };
};
