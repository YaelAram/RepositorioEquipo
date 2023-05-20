package ico.fes.tec.diosesAPI.model;

import java.util.*;

public class GestorUsuarios {
  private static GestorUsuarios GESTOR = null;
  private final HashMap<String, Usuario> usuarios = new HashMap<>();

  private GestorUsuarios(){
    Usuario aux = new Usuario(
            UUID.fromString("c1c68d68-4cc0-4879-8e20-0d4e04ab4758"),
            "Admin",
            "admin@gmail.com",
            "123456",
            Rol.ADMIN
    );
    this.usuarios.put(aux.getId().toString(), aux);
  }

  public static GestorUsuarios obtenerGestor(){
    if(GESTOR == null) GESTOR = new GestorUsuarios();
    return GESTOR;
  }

  public boolean validarRol(String token){
    Usuario usuario = this.usuarios.get(token);
    if(usuario != null) return usuario.getRol() == Rol.ADMIN;
    return false;
  }

  public ArrayList<UsuarioSeguro> obtenerUsuarios(){
    return new ArrayList<>(this.usuarios.values().stream().map(Usuario::obtenerUsuarioSeguro).toList());
  }

  public UsuarioSeguro crearUsuario(Usuario nuevoUsuario){
    boolean isRegistered = this.usuarios.entrySet().stream()
            .anyMatch((usuario) -> usuario.getValue().getEmail().equals(nuevoUsuario.getEmail()));
    if(isRegistered) return nuevoUsuario.obtenerUsuarioSeguro();
    else{
      Usuario usuario = Usuario.crearUsuario(nuevoUsuario);
      this.usuarios.put(usuario.getId().toString(), usuario);
      return usuario.obtenerUsuarioSeguro();
    }
  }

  public UsuarioSeguro autenticar(Usuario usuarioDesconocido){
    Usuario usuarioEncontrado = this.usuarios.values().stream()
            .filter(usuario -> usuario.getEmail().equals(usuarioDesconocido.getEmail()))
            .findFirst()
            .orElse(usuarioDesconocido);
    if(usuarioEncontrado.getId() == null || !usuarioEncontrado.compararPassword(usuarioDesconocido)) return usuarioDesconocido.obtenerUsuarioSeguro();
    return usuarioEncontrado.obtenerUsuarioSeguro();
  }

  public UsuarioSeguro cambiarRol(String id, Usuario usuarioActualizado){
    if(!this.usuarios.containsKey(id)) return usuarioActualizado.obtenerUsuarioSeguro();
    else{
      Usuario usuario = this.usuarios.get(id);
      usuario.setRol(usuarioActualizado.getRol());
      return usuario.obtenerUsuarioSeguro();
    }
  }

  public UsuarioSeguro eliminarUsuario(String id){
    if(!this.usuarios.containsKey(id)) return new UsuarioSeguro();
    else return this.usuarios.remove(id).obtenerUsuarioSeguro();
  }
}
