import { useCreateGod } from "../hooks";

export function CreateGod() {
  const { handleSubmit, img, nombre, epiteto, panteon, rol, onInputChange } = useCreateGod();

  return (
    <section className="section-create">
      <h1 className="h1-create">Crear Dios</h1>
      <form className="form-create" onSubmit={ handleSubmit }>
        <label htmlFor="img-god">Imagen: </label>
        <input type="text" name="img" id="img-god" value={ img } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="nom-god">Nombre: </label>
        <input type="text" name="nombre" id="nom-god" value={ nombre } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="epiteto-god">Epiteto: </label>
        <input type="text" name="epiteto" id="epiteto-god" value={ epiteto } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="panteon-god">Panteon: </label>
        <input type="text" name="panteon" id="panteon-god" value={ panteon } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="rol-god">Rol: </label>
        <input type="text" name="rol" id="rol-god" value={ rol } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <input type="submit" value="Crear" className="btn-create" />
      </form>
    </section>
  );
}
