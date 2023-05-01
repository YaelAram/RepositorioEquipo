import { useEffect, useState } from "react";

import { useNavigate, useParams } from "react-router-dom";

import Swal from 'sweetalert2';
import { UpdateForm } from "../components/UpdateForm";

const url = 'http://localhost:8081/api/dioses/';

export function God() {
  const [ god, setGod ] = useState( {} );
  const { img, nombre, panteon } = god;

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect( () => {
    const getGod = async () => {
      const resp = await fetch( `${ url }${ id }`, { method: 'GET' } );
      const data = await resp.json();
      setGod( data );
    };

    getGod();
  }, [] );

  const handleDelete = async () => {
    const resp = await fetch( `${ url }${ id }`, { method: 'DELETE' } );
    const data = await resp.json();

    if( resp.ok ) {
      Swal.fire( { title: '¡Exito!', text: `${ data.nombre } borrado`, icon: 'success', confirmButtonText: 'Ok', confirmButtonColor: "#000" } );
      navigate( '/', { replace: true } );
    }
    else Swal.fire( { title: 'Error', text: 'El dios no se borro', icon: 'error', confirmButtonText: 'Ok', confirmButtonColor: "#000" } );
  };

  return (
    <section>
      <div className="image-info-profile">
        <img src={ img } alt={ `${ nombre } ${ panteon } god` } className="hero-img-profile" />
        <article className="hero-info-profile">
          { ( img ) ? <UpdateForm { ...god } /> : undefined }
          <button className="hero-profile-delete btn-create" onClick={ handleDelete }>Eliminar Dios</button>
        </article>
      </div>
    </section>
  );
}
