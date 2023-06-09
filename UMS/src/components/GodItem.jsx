import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

export function GodItem( { id, img, nombre, epiteto, panteon, rol } ) {
  return (
    <article className="god-item rounded">
      <h3>{ `${ nombre }` }</h3>
      <div className="grid image-info">
        <img src={ img } alt={ `${ nombre } ${ panteon } god` } />
        <div className="god-info">
          <p><span className="label-god-info">Epíteto: </span>{ epiteto }</p>
          <p><span className="label-god-info">Rol: </span>{ rol }</p>
          <Link to={ `/${ id }` } className="about-god-info">Más...</Link>
        </div>
      </div>
    </article>
  );
}

GodItem.propTypes = {
  id: PropTypes.string.isRequired,
  img: PropTypes.string.isRequired,
  nombre: PropTypes.string.isRequired,
  epiteto: PropTypes.string.isRequired,
  panteon: PropTypes.string.isRequired,
  rol: PropTypes.string.isRequired
};
