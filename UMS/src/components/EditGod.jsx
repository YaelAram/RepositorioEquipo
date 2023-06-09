import PropTypes from 'prop-types';

import { UpdateForm } from './UpdateForm';
import { useEditGod } from '../hooks';

export function EditGod( { god } ) {
  const { handleDelete } = useEditGod( god?.id );

  return (
    <>
      <UpdateForm { ...god } />
      <button className="btn empty-btn rounded bordered god-profile-delete btn-create" onClick={ handleDelete }>
        Eliminar
      </button>
    </>
  );
};

EditGod.propTypes = {
  god: PropTypes.object.isRequired
};
