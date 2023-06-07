import { EditGod, ReadOnlyGod } from "../components";

import { useGod } from "../hooks";

export function God() {
  const { rol, god, img, alt } = useGod();

  return (
    <section>
      <div className="image-info-profile">
        <img src={ img } alt={ alt } className="hero-img-profile" />
        <article className="hero-info-profile">
          { ( !god?.id ) ? undefined : ( rol === 'ADMIN' ) ? <EditGod god={ god }/> : <ReadOnlyGod { ...god }/> }
        </article>
      </div>
    </section>
  );
};
