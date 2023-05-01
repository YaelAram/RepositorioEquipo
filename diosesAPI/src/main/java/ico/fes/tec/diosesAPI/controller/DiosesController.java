package ico.fes.tec.diosesAPI.controller;

import ico.fes.tec.diosesAPI.model.Dios;
import ico.fes.tec.diosesAPI.model.Roster;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DiosesController {
    private final Roster roster = new Roster();

    @GetMapping("/dioses/")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<ArrayList<Dios>> getDioses() {
        return new ResponseEntity<>(this.roster.obtenerDioses(), HttpStatus.OK);
    }

    @GetMapping("/dioses/{id}")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<Dios> getDiosByID(@PathVariable(name = "id") String id) {
        Dios dios = this.roster.obtenerDiosPorId(id);
        return new ResponseEntity<>(this.roster.obtenerDiosPorId(id), (dios.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @PostMapping("/dioses/")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<Dios> AgregarDios(@RequestBody() Dios diosNuevo){
        Dios dios = this.roster.crearDios(diosNuevo);
        return new ResponseEntity<>(dios, (dios.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED);
    }

    @PatchMapping("/dioses/{id}")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<Dios> ModificarDios(@PathVariable(name = "id") String id, @RequestBody() Dios diosActualizado){
        Dios dios = this.roster.actualizarDios(id, diosActualizado);
        return new ResponseEntity<>(dios, (dios.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @DeleteMapping("/dioses/{id}")
    @CrossOrigin(origins = "https://smite-dioses-api.netlify.app/")
    public ResponseEntity<Dios> EliminarDios(@PathVariable(name = "id") String id){
        Dios dios = this.roster.eliminarDios(id);
        return new ResponseEntity<>(dios, (dios.getId() == null) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }
}
