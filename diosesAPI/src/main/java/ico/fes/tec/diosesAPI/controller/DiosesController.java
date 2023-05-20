package ico.fes.tec.diosesAPI.controller;

import ico.fes.tec.diosesAPI.model.Dios;
import ico.fes.tec.diosesAPI.model.GestorUsuarios;
import ico.fes.tec.diosesAPI.model.Roster;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/dioses")
public class DiosesController {
    private final GestorUsuarios gestorUsuarios = GestorUsuarios.obtenerGestor();
    private final Roster roster = new Roster();

    @GetMapping("/")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<ArrayList<Dios>> getDioses() {
        return new ResponseEntity<>(this.roster.obtenerDioses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<Dios> getDiosByID(@PathVariable(name = "id") String id) {
        Dios dios = this.roster.obtenerDiosPorId(id);
        return new ResponseEntity<>(this.roster.obtenerDiosPorId(id), (dios.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @PostMapping("/")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<Dios> agregarDios(
            @RequestBody() Dios diosNuevo,
            @RequestHeader("token") String token
    ){
        if(!this.gestorUsuarios.validarRol(token)) return new ResponseEntity<>(diosNuevo, HttpStatus.UNAUTHORIZED);
        Dios dios = this.roster.crearDios(diosNuevo);
        return new ResponseEntity<>(dios, (dios.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<Dios> modificarDios(
            @PathVariable(name = "id") String id,
            @RequestBody() Dios diosActualizado,
            @RequestHeader("token") String token
    ){
        if(!this.gestorUsuarios.validarRol(token)) return new ResponseEntity<>(diosActualizado, HttpStatus.UNAUTHORIZED);
        Dios dios = this.roster.actualizarDios(id, diosActualizado);
        return new ResponseEntity<>(dios, (dios.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<Dios> eliminarDios(
            @PathVariable(name = "id") String id,
            @RequestHeader("token") String token
    ){
        if(!this.gestorUsuarios.validarRol(token)) return new ResponseEntity<>(new Dios(), HttpStatus.UNAUTHORIZED);
        Dios dios = this.roster.eliminarDios(id);
        return new ResponseEntity<>(dios, (dios.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }
}
