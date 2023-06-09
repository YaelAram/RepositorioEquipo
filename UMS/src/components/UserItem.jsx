import PropTypes from 'prop-types';

import { useUserItem } from '../hooks/useUserItem';

export function UserItem( { id, nombre, email, rol, deleteUserUI, updateUserUI } ) {
  const { handleDelete, handleRolChanged } = useUserItem( id, deleteUserUI, updateUserUI );

  return (
    <section className="grid section-user rounded">
      <p className="info-user">{ nombre }</p>
      <p className="info-user">{ email }</p>
      <p className="info-user">{ rol }</p>
      <select defaultValue={ rol } title="Role selector" onChange={ handleRolChanged }>
        <option value="ADMIN">Administrador</option>
        <option value="PLAYER">Jugador</option>
      </select>
      <button type="button" className="btn empty-btn rounded bordered delete-user-btn" onClick={ handleDelete }>Borrar</button>
    </section>
  );
};

UserItem.propTypes = {
  id: PropTypes.string.isRequired,
  nombre: PropTypes.string.isRequired,
  email: PropTypes.string.isRequired,
  rol: PropTypes.string.isRequired,
  deleteUserUI: PropTypes.func.isRequired,
  updateUserUI: PropTypes.func.isRequired
};
