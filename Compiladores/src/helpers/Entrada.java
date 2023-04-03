package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class Entrada {
  private String ruta;
  private String datos = null;
  private int caracteres = 0;
  private final HashMap<Character, Integer> caracteresDif = new HashMap<>();
  private final HashMap<String, String> salidas = new HashMap<>();

  public static final boolean ELIMINAR_REPETIDOS = true;
  public static final boolean MANTENER_REPETIDOS = false;

  public Entrada(String ruta) {
    this.ruta = ruta;

    salidas.put("\n", "\\n (Salto de linea)");
    salidas.put("\r", "\\r (Retorno de carro)");
    salidas.put(" ", "ESPACIO");
    salidas.put("\r\n", "\\r\\n SALTO DE LINEA (WINDOWS)");
  }

  public String getDatos() {
    return datos;
  }

  public String obtenerNumeroCaracteres() {
    return "Total de caracteres: " + this.caracteres;
  }

  public Entrada leerTodo(){
    try{
      FileInputStream fileInputStream = new FileInputStream(this.ruta);
      this.caracteres = fileInputStream.available();
      this.datos = new String(fileInputStream.readAllBytes());
      fileInputStream.close();
    }
    catch(IOException error){
      System.out.println(error.getMessage());
    }

    return this;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
  }

  public String contarCaracteres(){
    try{
      FileInputStream fileInputStream = new FileInputStream(this.ruta);
      char caracter;
      this.datos = "";

      while(fileInputStream.available() != 0){
        caracter = (char) fileInputStream.read();
        this.datos = this.datos.concat(String.valueOf(caracter));
        if(caracteresDif.containsKey(caracter))
          caracteresDif.replace(caracter, caracteresDif.get(caracter) + 1);
        else caracteresDif.put(caracter, 1);
      }

      fileInputStream.close();
    }
    catch(IOException error){
      System.out.println(error.getMessage());
    }

    return this.crearMensajeCaracteresDiferentes();
  }

  private String crearSalida(String caracter){
    return this.salidas.getOrDefault(caracter, caracter);
  }

  private String crearMensajeCaracteresDiferentes(){
    StringBuilder mensaje = new StringBuilder();
    this.caracteresDif.forEach((clave, valor) -> {
      String veces = (valor > 1) ? " veces" : " vez";
      mensaje.append("Caracter ").append(crearSalida(String.valueOf(clave)))
              .append(" encontrado ").append(valor).append(veces).append("\n");
    });

    return mensaje.toString();
  }

  public String contador(String separador, String nombreSingular, String nombrePlural, boolean eliminar){
    this.leerTodo();
    String datosCopia = this.datos;
    if(eliminar) datosCopia = datosCopia.replaceAll("(" + separador + "){2,}", separador);
    int numeroPalabras = datosCopia.split(separador).length;

    return "Separador " + crearSalida(separador) +
            "\nTotal de palabras: " + numeroPalabras + " " + ((numeroPalabras != 1) ? nombrePlural : nombreSingular);
  }
}
