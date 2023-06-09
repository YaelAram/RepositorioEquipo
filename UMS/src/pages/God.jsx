import { EditGod, ReadOnlyGod } from "../components";

import { useGod } from "../hooks";

export function God() {
  const { rol, god, img, alt } = useGod();

  return (
    <section>
      <div className="grid image-info-profile">
        <img src={ img } alt={ alt } className="god-img-profile rounded shadow" />
        <article className="god-info-profile shadow rounded">
          { ( !god?.id ) ? undefined : ( rol === 'ADMIN' ) ? <EditGod god={ god }/> : <ReadOnlyGod { ...god }/> }
        </article>
      </div>
    </section>
  );
};
