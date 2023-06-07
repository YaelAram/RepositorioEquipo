import PropTypes from 'prop-types';

export function ReadOnlyGod( { nombre, epiteto, panteon, rol } ) {
  return (
    <>
      <p><span className="label-hero-info">Nombre: </span>{ nombre }</p>
      <p><span className="label-hero-info">Epiteto: </span>{ epiteto }</p>
      <p><span className="label-hero-info">Panteon: </span>{ panteon }</p>
      <p><span className="label-hero-info">Rol: </span>{ rol }</p>
    </>
  );
};

ReadOnlyGod.propTypes = {
  nombre: PropTypes.string.isRequired,
  epiteto: PropTypes.string.isRequired,
  panteon: PropTypes.string.isRequired,
  rol: PropTypes.string.isRequired
};
