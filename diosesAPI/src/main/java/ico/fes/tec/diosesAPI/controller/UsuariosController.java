package ico.fes.tec.diosesAPI.controller;

import ico.fes.tec.diosesAPI.model.GestorUsuarios;
import ico.fes.tec.diosesAPI.model.Usuario;
import ico.fes.tec.diosesAPI.model.UsuarioSeguro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
  private final GestorUsuarios gestorUsuarios = GestorUsuarios.obtenerGestor();

  @GetMapping("/")
  @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
  public ResponseEntity<ArrayList<UsuarioSeguro>> obtenerUsuarios(){
    return new ResponseEntity<>(gestorUsuarios.obtenerUsuarios(), HttpStatus.OK);
  }

  @PostMapping("/")
  @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
  public ResponseEntity<UsuarioSeguro> crearUsuario(@RequestBody() Usuario nuevoUsuario){
    UsuarioSeguro usuario = gestorUsuarios.crearUsuario(nuevoUsuario);
    return new ResponseEntity<>(usuario, (usuario.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED);
  }

  @PostMapping("/auth")
  @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
  public ResponseEntity<UsuarioSeguro> logIn(@RequestBody() Usuario usuarioDesconocido){
    UsuarioSeguro usuario = this.gestorUsuarios.autenticar(usuarioDesconocido);
    return new ResponseEntity<>(usuario, (usuario.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
  public ResponseEntity<UsuarioSeguro> cambiarRol(
          @PathVariable(name = "id") String id,
          @RequestBody() Usuario usuarioActualizado,
          @RequestHeader("token") String token
  ){
    if(!this.gestorUsuarios.validarRol(token)) return new ResponseEntity<>(new UsuarioSeguro(), HttpStatus.UNAUTHORIZED);
    UsuarioSeguro usuario = this.gestorUsuarios.cambiarRol(id, usuarioActualizado);
    return new ResponseEntity<>(usuario, (usuario.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
  public ResponseEntity<UsuarioSeguro> eliminarUsuario(
          @PathVariable(name = "id") String id,
          @RequestHeader("token") String token
  ){
    if(!this.gestorUsuarios.validarRol(token)) return new ResponseEntity<>(new UsuarioSeguro(), HttpStatus.UNAUTHORIZED);
    UsuarioSeguro usuario = this.gestorUsuarios.eliminarUsuario(id);
    return new ResponseEntity<>(usuario, (usuario.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
  }
}
