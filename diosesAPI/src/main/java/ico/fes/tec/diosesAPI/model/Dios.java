package ico.fes.tec.diosesAPI.model;

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

    private static String validarImg(String img, String defaultImg){
        return (img.matches("[a-zA-Z0-9-_/:.]+.(png|jpg|jpeg)")) ? img : defaultImg;
    }

    private static String validarTexto(String name, String defaultName){
        return (name.matches("[a-zA-ZñÑ ]+")) ? name : defaultName;
    }

    public static Dios crearDios(Dios dios){
        return new Dios(
            UUID.randomUUID(),
            validarImg(dios.getImg(), "Sin imagen"),
            validarTexto(dios.getNombre(), "Sin nombre"),
            validarTexto(dios.getEpiteto(), "Sin epiteto"),
            validarTexto(dios.getPanteon(), "Sin panteon"),
            validarTexto(dios.getRol(), "Sin rol"),
            true
        );
    }

    public void actualizarDios(Dios dios){
        this.img = validarImg(dios.getImg(), this.img);
        this.nombre = validarTexto(dios.getNombre(), this.nombre);
        this.epiteto = validarTexto(dios.getEpiteto(), this.epiteto);
        this.panteon = validarTexto(dios.getPanteon(), this.panteon);
        this.rol = validarTexto(dios.getRol(), this.rol);
    }
}
