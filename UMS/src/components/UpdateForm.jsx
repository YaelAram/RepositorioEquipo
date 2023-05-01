import { useRef } from 'react';
import PropTypes from 'prop-types';

import Swal from 'sweetalert2';

const url = 'http://localhost:8081/api/dioses/';

export function UpdateForm( { id, nombre, epiteto, panteon, rol } ) {
  const nombreCampo = useRef();
  const epitetoCampo = useRef();
  const panteonCampo = useRef();
  const rolCampo = useRef();

  const handleSubmit = async ( evt ) => {
    evt.preventDefault();

    const god = {
      nombre: nombreCampo.current.value,
      epiteto: epitetoCampo.current.value,
      panteon: panteonCampo.current.value,
      rol: rolCampo.current.value,
    };

    const resp = await fetch( `${ url }${ id }`, { 
      method: 'PATCH', 
      headers:{'content-type': 'application/json'},
      body: JSON.stringify( god )
    } );
    const data = await resp.json();

    if( resp.ok ) {
      Swal.fire( { title: '¡Exito!', text: `${ data.nombre } actualizado`, icon: 'success', confirmButtonText: 'Ok', confirmButtonColor: "#000" } );
      navigate( '/', { replace: true } );
    }
    else Swal.fire( { title: 'Error', text: 'El dios no se actualizo', icon: 'error', confirmButtonText: 'Ok', confirmButtonColor: "#000" } );
  };

  return (
    <>
      <form className="form-create" onSubmit={ handleSubmit }>
        <label htmlFor="dios-nombre">Nombre:</label>
        <input type="text" name="nombreCampo" id="dios-nombre" className="input-create" placeholder={ nombre } ref={ nombreCampo } />
        <label htmlFor="epiteto-nombre">Epiteto:</label>
        <input type="text" name="epitetoCampo" id="epiteto-nombre" className="input-create" placeholder={ epiteto } ref={ epitetoCampo } />
        <label htmlFor="panteon-nombre">Panteon:</label>
        <input type="text" name="panteonCampo" id="panteon-nombre" className="input-create" placeholder={ panteon } ref={ panteonCampo } />
        <label htmlFor="rol-nombre">Rol:</label>
        <input type="text" name="rolCampo" id="rol-nombre" className="input-create" placeholder={ rol } ref={ rolCampo } />
        <input className="hero-profile-delete btn-create" type="submit" value="Actualizar Dios" />
      </form>
    </>
  );
};

UpdateForm.propTypes = {
  id: PropTypes.string.isRequired,
  nombre: PropTypes.string.isRequired,
  epiteto: PropTypes.string.isRequired,
  panteon: PropTypes.string.isRequired,
  rol: PropTypes.string.isRequired
};
