package model;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Entrada {
  private String ruta;
  private String codigo = "";

  public Entrada(String ruta) {
    this.ruta = ruta;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
  }

  public void mostrarMensaje(String mensaje){
    JOptionPane.showMessageDialog(null, mensaje, "Exito", JOptionPane.INFORMATION_MESSAGE);
  }

  public void analizar(){
    StringBuilder mensaje = new StringBuilder();
    this.codigo = "";

    try{
      FileInputStream fileInputStream = new FileInputStream(this.ruta);
      String acumulador = "";
      Conversor conversor = new Conversor();

      while(fileInputStream.available() != 0){
        String caracter = String.valueOf((char) fileInputStream.read());
        this.codigo = this.codigo.concat(caracter);
        String aux = acumulador.concat(caracter).toUpperCase();

        if (aux.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})")) {
          acumulador = aux;
          if(fileInputStream.available() == 0) mensaje.append(conversor.convertir(aux)).append("\n");
        }
        else {
          mensaje.append(conversor.convertir(acumulador)).append("\n");
          if(fileInputStream.available() == 0) mensaje.append(conversor.convertir(caracter)).append("\n");
          acumulador = caracter;
        }
      }

      fileInputStream.close();
    }
    catch(IOException error){
      System.out.println(error.getMessage());
    }

    mostrarMensaje(mensaje.toString());
  }
}
