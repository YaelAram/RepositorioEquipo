package model;

import java.io.FileInputStream;
import java.io.IOException;

public class Entrada {
  private final String ruta;

  public Entrada(String ruta) {
    this.ruta = ruta;
  }

  public void analizar(){
    try{
      FileInputStream fileInputStream = new FileInputStream(this.ruta);
      String acumulador = "";
      Conversor conversor = new Conversor();

      while(fileInputStream.available() != 0){
        String caracter = String.valueOf((char) fileInputStream.read());
        String aux = acumulador.concat(caracter).toUpperCase();

        if (aux.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})")) {
          acumulador = aux;
          if(fileInputStream.available() == 0) conversor.convertir(aux);
        }
        else {
          conversor.convertir(acumulador);
          if(fileInputStream.available() == 0) conversor.convertir(caracter);
          acumulador = caracter;
        }
      }

      fileInputStream.close();
    }
    catch(IOException error){
      System.out.println(error.getMessage());
    }
  }
}
