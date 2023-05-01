package ico.fes.tec.diosesAPI.model;
import java.util.ArrayList;
import java.util.HashMap;


public class Roster {
    HashMap<Integer, Dios> db;

    ArrayList <Bitacora> log;


    public ArrayList<Bitacora> getLog() {
        return log;
    }
    public void setLog(ArrayList<Bitacora> log) {
        this.log = log;
    }

    public Roster(HashMap<Integer, Dios> db) {this.db = db;}

    public HashMap<Integer, Dios> getDb() {
        return db;
    }

    public void setDb(HashMap<Integer, Dios> db) {
        this.db = db;
    }

    @Override
    public String toString() {
        return "roster{" +
                "db=" + db +
                '}';
    }

    public Roster(){
        db = new HashMap<Integer, Dios>();
        db.put(0, new Dios(0, "Apolo", "Dios de la Música", "Griego", "Cazador"));
        db.put(1, new Dios(1, "Scylla", "El Terror del Mar", "Griego", "Mago"));
        db.put(2, new Dios(2, "Tiamat", "Diosa primordial del Mar salado", "Babilónico", "Mago"));
        db.put(3, new Dios(3, "Ares", "Dios de la Guerra", "Griego", "Tanque"));
        db.put(4, new Dios(4, "Thanatos", "Dios de Muerte", "Griego", "Asesino"));
        db.put(5, new Dios(5, "Cthulhu", "El gran Soñador", "Los Antiguos", "Tanque"));
        db.put(6, new Dios(6, "Bakasura", "El gran Devorador", "Hindú", "Asesino"));
        db.put(7, new Dios(7, "AhPuch", "El dios horrífico de la Putrefacción", "Maya", "Mago"));
    }

    public Dios RegresarID(Integer id){
        return db.get(id);
    }

    public Dios AgregarDios(Dios dios){
        return db.put(dios.getId(),dios);
    }

    public Dios ModificarDios(Integer id, Dios Ndios){
        return db.replace(id,Ndios);

    }

    public Dios EliminarDios(Dios dios){
        return db.remove(dios.getId());
    }
}
