import { GodList } from '../components/GodList'
import { useShowGods } from "../hooks";

export function ShowGods() {
  const { isLoading, gods } = useShowGods();

  return (
    <section>
      <h1>Dioses</h1>
      { ( isLoading ) ? undefined : <GodList gods={ gods } /> }
    </section>
  );
}
