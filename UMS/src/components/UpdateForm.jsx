import PropTypes from 'prop-types';

import { useUpdateGod } from '../hooks';

export function UpdateForm( { id, nombre, epiteto, panteon, rol } ) {
  const {
    handleSubmit,
    nombreCampo,
    epitetoCampo,
    panteonCampo,
    rolCampo
  } = useUpdateGod( id );

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
