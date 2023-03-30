import helpers.Entrada;

public class Main {
  public static void main(String[] args) {
    System.out.println("Leyendo archivo...");
    Entrada entrada = new Entrada("test.txt");
    entrada.leerTodo();

    System.out.println("\nPrograma 1");
    System.out.println("Total de caracteres: " + entrada.getCaracteres());

    System.out.println("\nPrograma 2");
    entrada.contarCaracteres().mostrarCaracteresDiferentes();

    System.out.println("\nPrograma 3");
    entrada.contador(" ", "palabra", "palabras", Entrada.MANTENER_REPETIDOS);

    System.out.println("\nPrograma 4");
    entrada.contador(System.lineSeparator(), "linea", "lineas", Entrada.ELIMINAR_REPETIDOS);
  }
}