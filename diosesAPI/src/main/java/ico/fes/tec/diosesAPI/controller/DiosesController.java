package ico.fes.tec.diosesAPI.controller;

import ico.fes.tec.diosesAPI.model.Dios;
import ico.fes.tec.diosesAPI.model.Roster;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController

public class DiosesController {
    Roster roster;

    public DiosesController() {
        roster = new Roster();
    }

    @GetMapping("/dioses")
    public ResponseEntity<HashMap<Integer, Dios>> getDioses() {
        return new ResponseEntity<>(roster.getDb(), HttpStatus.OK);
    }

    @GetMapping("/dioses/{id}")
    public ResponseEntity<Dios> getDiosByID(@PathVariable(required = true, name = "id")Integer id) {
        return new ResponseEntity<>(roster.RegresarID(id), HttpStatus.OK);
    }

    @PostMapping("/dioses/agregar")
    public ResponseEntity<Dios> AgregarDios(@RequestBody(required = true) Dios ND){
        return new ResponseEntity<>(roster.AgregarDios(ND),HttpStatus.OK);
    }

    @PatchMapping("/dioses/reemplazar/{id}")
    public ResponseEntity<Dios> ModificarDios(@PathVariable(required = true, name = "id") Integer id, @RequestBody(required = true) Dios ND){
        return new ResponseEntity<>(roster.ModificarDios(id, ND),HttpStatus.OK);
    }

    @DeleteMapping("/dioses/eliminar")
    public ResponseEntity<Dios> EliminarDios(@RequestBody(required = true)Dios dios){
        return new ResponseEntity<>(roster.EliminarDios(dios),HttpStatus.OK);
    }

}
