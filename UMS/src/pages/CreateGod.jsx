import { useCreateGod } from "../hooks";

export function CreateGod() {
  const { handleSubmit, img, nombre, epiteto, panteon, rol, onInputChange } = useCreateGod();

  return (
    <section className="grid form-section">
      <div className='form-container shadow rounded'>
        <h1 className="form-title">Crear Dios</h1>
        <form className="grid" onSubmit={ handleSubmit }>
          <label htmlFor="img-god" className="label-field">Imagen: </label>
          <input 
            type="text" 
            name="img" 
            id="img-god" 
            value={ img } 
            onChange={ onInputChange } 
            className="input-field rounded bordered" 
            autoComplete="off" />
          <label htmlFor="nom-god" className="label-field">Nombre: </label>
          <input 
            type="text" 
            name="nombre" 
            id="nom-god" 
            value={ nombre } 
            onChange={ onInputChange } 
            className="input-field rounded bordered" 
            autoComplete="off" />
          <label htmlFor="epiteto-god" className="label-field">Epíteto: </label>
          <input 
            type="text" 
            name="epiteto" 
            id="epiteto-god" 
            value={ epiteto } 
            onChange={ onInputChange } 
            className="input-field rounded bordered" 
            autoComplete="off" />
          <label htmlFor="panteon-god" className="label-field">Panteón: </label>
          <input 
            type="text" 
            name="panteon" 
            id="panteon-god" 
            value={ panteon } 
            onChange={ onInputChange } 
            className="input-field rounded bordered" 
            autoComplete="off" />
          <label htmlFor="rol-god" className="label-field">Rol: </label>
          <input 
            type="text" 
            name="rol" 
            id="rol-god" 
            value={ rol } 
            onChange={ onInputChange } 
            className="input-field rounded bordered" 
            autoComplete="off" />
          <button type="submit" className="btn rounded bordered filled-btn">Crear</button>
        </form>
      </div>
    </section>
  );
}
