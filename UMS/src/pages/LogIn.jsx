import { useLogIn } from '../hooks';

export function LogIn() {
  const { handleSubmit, email, password, onInputChange } = useLogIn();

  return (
    <section className="section-create">
      <h1 className="h1-create">Iniciar Sesion</h1>
      <form className="form-create" onSubmit={ handleSubmit }>
        <label htmlFor="img-god">Email: </label>
        <input type="email" name="email" id="email-user" value={ email } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <label htmlFor="nom-god">Password: </label>
        <input type="password" name="password" id="pass-user" value={ password } onChange={ onInputChange } className="input-create" autoComplete="off" />
        <input type="submit" value="Iniciar Sesion" className="btn-create" />
      </form>
    </section>
  );
};
