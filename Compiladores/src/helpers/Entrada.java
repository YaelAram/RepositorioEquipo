package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Entrada {
  private final String ruta;
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

  public int getCaracteres() {
    return this.caracteres;
  }

  public void leerTodo(){
    try{
      FileInputStream fileInputStream = new FileInputStream(this.ruta);
      this.caracteres = fileInputStream.available();
      this.datos = new String(fileInputStream.readAllBytes());
      fileInputStream.close();
    }
    catch(IOException error){
      System.out.println(error.getMessage());
    }
  }

  public Entrada contarCaracteres(){
    try{
      FileInputStream fileInputStream = new FileInputStream(this.ruta);
      char caracter;

      while(fileInputStream.available() != 0){
        caracter = (char) fileInputStream.read();
        if(caracteresDif.containsKey(caracter))
          caracteresDif.replace(caracter, caracteresDif.get(caracter) + 1);
        else caracteresDif.put(caracter, 1);
      }

      fileInputStream.close();
    }
    catch(IOException error){
      System.out.println(error.getMessage());
    }

    return this;
  }

  private String crearSalida(String caracter){
    return this.salidas.getOrDefault(caracter, caracter);
  }

  public void mostrarCaracteresDiferentes(){
    this.caracteresDif.forEach((clave, valor) -> {
      String veces = (valor > 1) ? " veces" : " vez";
      System.out.println("Caracter " + crearSalida(String.valueOf(clave)) + " encontrado " + valor + veces);
    });
  }

  public void contador(String separador, String nombreSingular, String nombrePlural, boolean eliminar){
    String datosCopia = this.datos;
    if(eliminar) datosCopia = datosCopia.replaceAll("(" + separador + "){2,}", separador);
    int numeroPalabras = datosCopia.split(separador).length;
    System.out.println("Separador " + crearSalida(separador) +
            "\nTotal de palabras: " + numeroPalabras + " " + ((numeroPalabras != 1) ? nombrePlural : nombreSingular) );
  }
}
