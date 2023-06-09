import { useSignIn } from "../hooks";

export function SignIn() {
  const { nombre, email, password, onInputChange, handleSubmit, handleGoToLogIn } = useSignIn();

  return (
    <section className="grid form-section">
      <div className='form-container shadow rounded'>
        <h1 className="form-title">Registro de Usuario</h1>
        <form className="grid" onSubmit={ handleSubmit }>
          <label htmlFor="name-user" className="label-field">Nombre: </label>
          <input
            type="text"
            name="nombre"
            id="name-user"
            placeholder="Usuario"
            value={ nombre }
            onChange={ onInputChange }
            className="rounded bordered input-field"
            autoComplete="off" />
          <label htmlFor="email-user" className="label-field">Correo Electrónico: </label>
          <input
            type="email"
            name="email"
            id="email-user"
            placeholder="usuario@gmail.com"
            value={ email }
            onChange={ onInputChange }
            className="rounded bordered input-field"
            autoComplete="off" />
          <label htmlFor="pass-user" className="label-field">Contraseña: </label>
          <input
            type="password"
            name="password"
            id="pass-user"
            placeholder="123456"
            value={ password }
            onChange={ onInputChange }
            className="rounded bordered input-field"
            autoComplete="off" />
          <button type="submit" className="btn rounded bordered filled-btn">Registrar</button>
        </form>
        <p className='form-message'>
          ¿Ya cuentas con una cuenta? Inicia sesión
          <span className='form-link' onClick={ handleGoToLogIn }>aquí</span>
        </p>
      </div>
    </section>
  );
};
