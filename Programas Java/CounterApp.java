package tarea02;
import java.util.Scanner;

public class CounterApp {
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Haz clic en el botón escribiendo 'clic' o escribe 'salir' para terminar.");
        while (true) {
            System.out.print("Escribe tu comando: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("clic")) {
                count++;
                System.out.println("Clics: " + count);
            } else if (input.equalsIgnoreCase("salir")) {
                System.out.println("Adiós. Total de clics: " + count);
                break;
            } else {
                System.out.println("Comando no reconocido. Escribe 'clic' o 'salir'.");
            }
        }

        scanner.close();
    }
}
