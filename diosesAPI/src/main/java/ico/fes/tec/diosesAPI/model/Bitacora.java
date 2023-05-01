package ico.fes.tec.diosesAPI.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Bitacora {
    private Date fecha;
    private Dios dios;
    private String accion;

}
