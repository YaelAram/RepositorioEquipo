import PropTypes from 'prop-types';
import { GodItem } from './GodItem';

export function GodList( { gods } ) {
  return (
    <main className="grid god-list">
      { gods.map( ( god ) => <GodItem key={ god.id } { ...god } /> ) }
    </main>
  );
}

GodList.propTypes = {
  gods: PropTypes.array.isRequired
};
