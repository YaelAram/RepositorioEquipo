package ico.fes.tec.diosesAPI.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


public class Roster {
    private final HashMap<String, Dios> dioses = new HashMap<>();

    public Roster(){
        String[] ids = new String[]{
                "95b01682-174d-43d0-9e28-99e33046c437",
                "8b6fbad8-1a44-4acc-b9f6-031b66dc8d45",
                "18d0b75f-07e7-4116-bcc1-e3ab5a756ece",
                "c146f4ba-53a1-4835-9da3-74da694997b7",
                "899f6267-541d-4e1a-8e5c-068462f080c0",
                "838abfa0-43b7-4834-b11d-ecab000c88d2",
                "1188a892-a817-498a-86ef-0ecccd83493f",
                "b3128586-0aa9-44b8-80dc-72b5f052965a"
        };
        String[] imagenes = new String[]{
                "https://webcdn.hirezstudios.com/smite/god-skins/apollo_standard-apollo.jpg",
                "https://webcdn.hirezstudios.com/smite/god-skins/scylla_standard-scylla.jpg",
                "https://webcdn.hirezstudios.com/smite/god-skins/tiamat_standard-tiamat.jpg",
                "https://webcdn.hirezstudios.com/smite/god-skins/ares_standard-ares.jpg",
                "https://webcdn.hirezstudios.com/smite/god-skins/thanatos_standard-thanatos.jpg",
                "https://webcdn.hirezstudios.com/smite/god-skins/cthulhu_standard-cthulhu.jpg",
                "https://webcdn.hirezstudios.com/smite/god-skins/bakasura_standard-bakasura.jpg",
                "https://webcdn.hirezstudios.com/smite/god-skins/ah_puch_standard-ah-puch.jpg"
        };
        String[] nombres = new String[]{"Apolo", "Scylla", "Tiamat", "Ares", "Thanatos", "Cthulhu", "Bakasura", "Ah Puch"};
        String[] epitetos = new String[]{"Dios de la Música", "El Terror del Mar", "Diosa primordial del Mar salado", "Dios de la Guerra", "Dios de Muerte", "El gran Soñador", "El gran Devorador", "El dios horrífico de la Putrefacción"};
        String[] panteones = new String[]{"Griego", "Griego", "Babilónico", "Griego", "Griego", "Los Antiguos", "Hindú", "Maya"};
        String[] roles = new String[]{"Cazador", "Mago", "Mago", "Tanque", "Asesino", "Tanque", "Asesino", "Mago"};

        for(int i = 0 ; i<nombres.length ; i++){
            Dios dios = new Dios(UUID.fromString(ids[i]), imagenes[i], nombres[i], epitetos[i], panteones[i], roles[i], true);
            this.dioses.put(dios.getId().toString(), dios);
        }
    }

    public ArrayList<Dios> obtenerDioses() {
        return new ArrayList<>(this.dioses.values());
    }

    public Dios obtenerDiosPorId(String id){
        return dioses.getOrDefault(id, new Dios());
    }

    public Dios crearDios(Dios nuevoDios){
        boolean isRegistered = this.dioses.entrySet().stream()
                .anyMatch((dios) -> dios.getValue().getNombre().equals(nuevoDios.getNombre()));
        if(isRegistered) return nuevoDios;
        else{
            Dios dios = Dios.crearDios(nuevoDios);
            this.dioses.put(dios.getId().toString(), dios);
            return dios;
        }
    }

    public Dios actualizarDios(String id, Dios diosActualizado){
        Dios dios = this.dioses.get(id);
        if(dios == null) return new Dios();
        else {
            dios.actualizarDios(diosActualizado);
            return dios;
        }
    }

    public Dios eliminarDios(String id){
        Dios diosEliminado = this.dioses.remove(id);
        if(diosEliminado == null) diosEliminado = new Dios();
        diosEliminado.setActive(false);
        return diosEliminado;
    }
}
