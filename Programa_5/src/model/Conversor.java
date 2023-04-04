package model;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class Conversor {
  private final HashMap<String, Integer> conversion = new HashMap<>();
  private final NumberFormat formato = NumberFormat.getInstance(new Locale("es", "MX"));

  public Conversor(){
    conversion.put("I", 1);
    conversion.put("IV", 4);
    conversion.put("V", 5);
    conversion.put("IX", 9);
    conversion.put("X", 10);
    conversion.put("XL", 40);
    conversion.put("L", 50);
    conversion.put("XC", 90);
    conversion.put("C", 100);
    conversion.put("CD", 400);
    conversion.put("D", 500);
    conversion.put("CM", 900);
    conversion.put("M", 1000);
  }

  public String convertir(String numero){
    int acumulador = 0;
    String[] segmentos = numero.split("");

    for(int i = 0 ; i<segmentos.length ; i++){
      String clave = segmentos[i] + (((i + 1) >= segmentos.length) ? "" : segmentos[i + 1]);

      if(clave.length() == 2 && this.conversion.containsKey(clave)){
        acumulador += this.conversion.get(clave);
        i += 1;
      }
      else acumulador += this.conversion.getOrDefault(segmentos[i], 0);
    }

    return "Valor encontrado: " + numero + " -> " + formato.format(acumulador);
  }
}
