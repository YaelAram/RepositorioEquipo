import { useContext } from "react";

import { UserContext } from "../context/UserContext";

import { useForm } from "./useForm";

import { logIn } from "../provider";
import { errorAlert } from "../alerts";

const formData = {
  email: '',
  password: ''
};

export const useLogIn = () => {
  const { form, email, password, onInputChange, onReset } = useForm( formData );

  const { logInUser } = useContext( UserContext );

  const handleSubmit = async ( evt ) => {
    evt.preventDefault();

    const { ok, data } = await logIn( form );

    if( !ok ) errorAlert( 'Error', 'Email y password no coinciden' );
    else{
      localStorage.setItem( 'user', JSON.stringify( data ) );
      onReset();
      logInUser( data );
    }
  };

  return {
    email,
    password,
    onInputChange,
    handleSubmit
  };
};
