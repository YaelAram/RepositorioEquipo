import model.Entrada;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programa 5\n");

        Entrada entrada = new Entrada("test.txt");
        entrada.analizar();
    }
}