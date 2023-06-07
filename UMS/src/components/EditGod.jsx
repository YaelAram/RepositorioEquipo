import PropTypes from 'prop-types';

import { UpdateForm } from './UpdateForm';
import { useEditGod } from '../hooks';

export function EditGod( { god } ) {
  const { handleDelete } = useEditGod( god?.id );

  return (
    <>
      <UpdateForm { ...god } />
      <button className="hero-profile-delete btn-create" onClick={ handleDelete }>Eliminar Dios</button>
    </>
  );
};

EditGod.propTypes = {
  god: PropTypes.object.isRequired
};
