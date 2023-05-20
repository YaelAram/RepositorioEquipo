package ico.fes.tec.diosesAPI.model;

import ico.fes.tec.diosesAPI.helpers.Validator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Usuario {
  private final UUID id;
  private String nombre;
  private String email;
  private String password;
  private Rol rol;

  public static Usuario crearUsuario(Usuario usuario){
    return new Usuario(
      UUID.randomUUID(),
      Validator.validarTexto(usuario.getNombre(), "Sin Nombre"),
      usuario.getEmail(),
      usuario.getPassword(),
      Rol.PLAYER
    );
  }

  public UsuarioSeguro obtenerUsuarioSeguro(){
    return new UsuarioSeguro(
      this.id,
      this.nombre,
      this.email,
      this.rol
    );
  }

  public boolean compararPassword(Usuario usuario){
    return this.password.equals(usuario.getPassword());
  }
}
