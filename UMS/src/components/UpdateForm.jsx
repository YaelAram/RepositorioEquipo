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
      <form className="grid form-update" onSubmit={ handleSubmit }>
        <label htmlFor="dios-nombre" className='label-field'>Nombre:</label>
        <input 
          type="text" 
          name="nombreCampo" 
          id="dios-nombre" 
          className="input-field rounded bordered" 
          placeholder={ nombre } 
          ref={ nombreCampo } />
        <label htmlFor="epiteto-nombre" className='label-field'>Epíteto:</label>
        <input 
          type="text" 
          name="epitetoCampo" 
          id="epiteto-nombre" 
          className="input-field rounded bordered" 
          placeholder={ epiteto } 
          ref={ epitetoCampo } />
        <label htmlFor="panteon-nombre" className='label-field'>Panteón:</label>
        <input 
          type="text" 
          name="panteonCampo" 
          id="panteon-nombre" 
          className="input-field rounded bordered" 
          placeholder={ panteon } 
          ref={ panteonCampo } />
        <label htmlFor="rol-nombre" className='label-field'>Rol:</label>
        <input 
          type="text" 
          name="rolCampo" 
          id="rol-nombre" 
          className="input-field rounded bordered" 
          placeholder={ rol } 
          ref={ rolCampo } />
        <button type='submit' className='btn filled-btn rounded bordered'>Actualizar</button>
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
