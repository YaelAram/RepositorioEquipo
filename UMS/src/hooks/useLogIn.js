import { useContext } from "react";

import { UserContext } from "../context/UserContext";

import { useForm } from "./useForm";

import { logIn } from "../provider";
import { errorAlert } from "../alerts";
import { useNavigate } from "react-router-dom";

const formData = {
  email: '',
  password: ''
};

export const useLogIn = () => {
  const { form, email, password, onInputChange, onReset } = useForm( formData );
  const { logInUser } = useContext( UserContext );
  const navigate = useNavigate();

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

  const handleGoToSignIn = () => {
    navigate( '/registro', { replace: true } );
  };

  return {
    email,
    password,
    onInputChange,
    handleSubmit,
    handleGoToSignIn
  };
};
