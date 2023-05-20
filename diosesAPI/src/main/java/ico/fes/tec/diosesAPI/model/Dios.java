package ico.fes.tec.diosesAPI.model;

import ico.fes.tec.diosesAPI.helpers.Validator;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Dios {
    private final UUID id;
    private String img;
    private String nombre;
    private String epiteto;
    private String panteon;
    private String rol;
    private boolean active;

    public Dios(){
        this.id = null;
        this.img = "Sin imagen";
        this.nombre = "Sin nombre";
        this.epiteto = "Sin epiteto";
        this.panteon = "Sin panteon";
        this.rol = "Sin rol";
    }

    public static Dios crearDios(Dios dios){
        return new Dios(
            UUID.randomUUID(),
            Validator.validarImg(dios.getImg(), "Sin imagen"),
            Validator.validarTexto(dios.getNombre(), "Sin nombre"),
            Validator.validarTexto(dios.getEpiteto(), "Sin epiteto"),
            Validator.validarTexto(dios.getPanteon(), "Sin panteon"),
            Validator.validarTexto(dios.getRol(), "Sin rol"),
            true
        );
    }

    public void actualizarDios(Dios dios){
        this.img = Validator.validarImg(dios.getImg(), this.img);
        this.nombre = Validator.validarTexto(dios.getNombre(), this.nombre);
        this.epiteto = Validator.validarTexto(dios.getEpiteto(), this.epiteto);
        this.panteon = Validator.validarTexto(dios.getPanteon(), this.panteon);
        this.rol = Validator.validarTexto(dios.getRol(), this.rol);
    }
}
