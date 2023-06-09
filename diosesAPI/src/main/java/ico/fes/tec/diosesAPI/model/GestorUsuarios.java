package ico.fes.tec.diosesAPI.model;

import java.util.*;

public class GestorUsuarios {
  private static GestorUsuarios GESTOR = null;
  private final HashMap<String, Usuario> usuarios = new HashMap<>();

  private GestorUsuarios(){
    Usuario admin = new Usuario(
            UUID.fromString("c1c68d68-4cc0-4879-8e20-0d4e04ab4758"),
            "Admin",
            "admin@gmail.com",
            "123456",
            Rol.ADMIN
    );
    Usuario player = new Usuario(
            UUID.fromString("48a78c38-7210-486a-b873-690311f42701"),
            "Player",
            "player@gmail.com",
            "123456",
            Rol.PLAYER
    );
    Usuario yael = new Usuario(
            UUID.fromString("a58e95f2-ab43-4c21-a3c6-43b3b37f5117"),
            "Yael",
            "yael@gmail.com",
            "123456",
            Rol.ADMIN
    );
    Usuario axel = new Usuario(
            UUID.fromString("822f7f8b-2b0d-4e83-92d1-33df21acd44b"),
            "Axel",
            "axel@gmail.com",
            "123456",
            Rol.PLAYER
    );
    Usuario joshua = new Usuario(
            UUID.fromString("4047e0c5-e2c0-472a-9c51-51b3c0ace8dd"),
            "Joshua",
            "joshua@gmail.com",
            "123456",
            Rol.ADMIN
    );
    this.usuarios.put(admin.getId().toString(), admin);
    this.usuarios.put(player.getId().toString(), player);
    this.usuarios.put(yael.getId().toString(), yael);
    this.usuarios.put(axel.getId().toString(), axel);
    this.usuarios.put(joshua.getId().toString(), joshua);
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

  public ArrayList<UsuarioSeguro> obtenerUsuarios(String token){
    return new ArrayList<>(this.usuarios.values()
            .stream()
            .map(Usuario::obtenerUsuarioSeguro)
            .filter((usuario) -> !usuario.getId().toString().equals(token))
            .toList());
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
