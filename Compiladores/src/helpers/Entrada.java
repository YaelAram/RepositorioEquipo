package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
// Clase que contendrá todos los mecanismos para realizar los programas requeridos para la tarea
public class Entrada {
  //Se inicializan las variables que usaremos
  private String ruta;
  private String datos = null;
  private int caracteres = 0;
  private final HashMap<Character, Integer> caracteresDif = new HashMap<>();
  private final HashMap<String, String> salidas = new HashMap<>();

  public static final boolean ELIMINAR_REPETIDOS = true;
  public static final boolean MANTENER_REPETIDOS = false;

  //Presenta un mensaje según el caracter encontrado
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

  //Se indica como presentar el total de caracteres
  public String obtenerNumeroCaracteres() {
    return "Total de caracteres: " + this.caracteres;
  }

  //Se genera un método que lea el texto
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

  //Se pone la ruta del archivo
  public void setRuta(String ruta) {
    this.ruta = ruta;
  }

  //Método de contar caracteres
  public String contarCaracteres(){
    try{
      //Se carga el archivo
      FileInputStream fileInputStream = new FileInputStream(this.ruta);
      char caracter;
      this.datos = "";


      while(fileInputStream.available() != 0){
        //Se lee y construye el texto caracter por caracter
        caracter = (char) fileInputStream.read();
        this.datos = this.datos.concat(String.valueOf(caracter));
        /*
        Realiza el conteo de caracteres, ya sea que haya y se sumen al conteo o
        Se inicialice una cuenta al encontrar un caracter leído por primera vez
         */
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

  //Genera la salida del texto
  private String crearSalida(String caracter){
    return this.salidas.getOrDefault(caracter, caracter);
  }

  //Se genera la salida del resultado del conteo
  private String crearMensajeCaracteresDiferentes(){
    StringBuilder mensaje = new StringBuilder();
    this.caracteresDif.forEach((clave, valor) -> {
      String veces = (valor > 1) ? " veces" : " vez";
      mensaje.append("Caracter ").append(crearSalida(String.valueOf(clave)))
              .append(" encontrado ").append(valor).append(veces).append("\n");
    });

    return mensaje.toString();
  }

  //Elementos para el separador
  public String contador(String separador, String nombreSingular, String nombrePlural, boolean eliminar){
    this.leerTodo();
    //Se genera una copia para no modificar el texto original
    String datosCopia = this.datos;
    /*
    En el caso de seleccionar eliminar repetidos; se elimina los repetidos encontrando los repetidos
    como mínimo 2 veces y dejando solo uno a mostrar
     */
    if(eliminar) datosCopia = datosCopia.replaceAll("(" + separador + "){2,}", separador);
    int numeroPalabras = datosCopia.split(separador).length;
    //Se genera la salida de texto como resultado de la separación del programa
    return "Separador " + crearSalida(separador) +
            "\nTotal de palabras: " + numeroPalabras + " " + ((numeroPalabras != 1) ? nombrePlural : nombreSingular);
  }
}
