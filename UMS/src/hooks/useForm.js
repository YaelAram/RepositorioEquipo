import { useState, useEffect, useMemo } from 'react';

export const useForm = ( initialState = {}, formValidators = {} ) => {
    const [ form, setForm ] = useState( initialState );
    const [ formValidation, setFormValidation ] = useState( {} );

    useEffect( () => createValidators(), [ form ] );
    useEffect( () => setForm( initialState ), [ initialState ] );

    const formValid = useMemo( () => {
        return Object.values( formValidation ).every( ( fieldMessage ) => fieldMessage === undefined ); 
    }, [ formValidation ] );

    const onInputChange = ( { target } ) => {
        const { name, value } = target;
        setForm( {
            ...form,
            [ name ]: value
        } );
    };

    const createValidators = () => {
        const newFormValidation = {};
        for( const formField of Object.keys( formValidators ) ){
            const [ fn, errorMessage ] = formValidators[ formField ];
            newFormValidation[ `${ formField }Valid` ] = fn( form[ formField ] ) ? undefined : errorMessage;
        }
        setFormValidation( newFormValidation );
    };

    const onReset = () => setForm( initialState );

    return {
        ...form,
        form,
        formValid,
        ...formValidation,
        onInputChange,
        onReset
    };
};
