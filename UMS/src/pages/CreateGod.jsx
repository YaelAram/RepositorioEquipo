import Swal from 'sweetalert2';

import { useForm } from "../hooks/useForm";

const url = 'http://localhost:8081/api/dioses/';
const formData = {
  img: '',
  nombre: '',
  epiteto: '',
  panteon: '',
  rol: ''
};

export function CreateGod() {
  const { form, img, nombre, epiteto, panteon, rol, onInputChange, onReset } = useForm( formData );

  const handleSubmit = async ( evt ) => {
    evt.preventDefault();

    const resp = await fetch( url, { 
      method: 'POST', 
      headers:{'content-type': 'application/json'},
      body: JSON.stringify(form)
    }  );
    const { id } = await resp.json();

    if( id ) {
      Swal.fire( { title: '¡Exito!', text: 'Dios creado', icon: 'success', confirmButtonText: 'Ok', confirmButtonColor: "#000" } );
      onReset();
    }
    else Swal.fire( { title: 'Error', text: 'El dios no fue creado', icon: 'error', confirmButtonText: 'Ok', confirmButtonColor: "#000" } );
  };

  return (
    <section className="section-create">
      <h1 className="h1-create">Crear Dios</h1>
      <form className="form-create" onSubmit={ handleSubmit }>
        <label htmlFor="img-god">Imagen: </label>
        <input type="text" name="img" id="img-god" value={ img } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="nom-god">Nombre: </label>
        <input type="text" name="nombre" id="nom-god" value={ nombre } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="epiteto-god">Epiteto: </label>
        <input type="text" name="epiteto" id="epiteto-god" value={ epiteto } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="panteon-god">Panteon: </label>
        <input type="text" name="panteon" id="panteon-god" value={ panteon } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="rol-god">Rol: </label>
        <input type="text" name="rol" id="rol-god" value={ rol } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <input type="submit" value="Crear" className="btn-create" />
      </form>
    </section>
  );
}
