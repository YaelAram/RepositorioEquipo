import { useLogIn } from '../hooks';

export function LogIn() {
  const { handleSubmit, email, password, onInputChange, handleGoToSignIn } = useLogIn();

  return (
    <section className="grid form-section">
      <div className='form-container shadow rounded'>
        <h1 className="form-title">Iniciar Sesión</h1>
        <form className="grid" onSubmit={ handleSubmit }>
          <label htmlFor="email-user" className='label-field'>Correo Electrónico: </label>
          <input
            type="email"
            name="email"
            id="email-user"
            placeholder="usuario@gmail.com"
            value={ email }
            onChange={ onInputChange }
            className="rounded bordered input-field" />
          <label htmlFor="pass-user" className='label-field'>Contraseña: </label>
          <input
            type="password"
            name="password"
            id="pass-user"
            placeholder="123456"
            value={ password }
            onChange={ onInputChange }
            className="rounded bordered input-field" />
            <button type='submit' className="btn rounded bordered filled-btn">Iniciar Sesión</button>
        </form>
        <p className='form-message'>
          ¿Aún no tienes una cuenta? Regístrate 
          <span className='form-link' onClick={ handleGoToSignIn }>aquí</span>
        </p>
      </div>
    </section>
  );
};
