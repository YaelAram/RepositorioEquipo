package ico.fes.tec.diosesAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@Getter
@ToString
public class UsuarioSeguro {
  private final UUID id;
  private String nombre;
  private String email;
  private Rol rol;

  public UsuarioSeguro(){
    this.id = null;
    this.nombre = "Sin Nombre";
    this.email = "Sin Email";
    this.rol = null;
  }
}
