package Actual;

import java.util.Scanner;

public class InterfazUsuario { 
	private Scanner scanner;

	public InterfazUsuario() {
	    scanner = new Scanner(System.in);
	}

	public String leerDato(String mensaje) {
	    System.out.print(mensaje + ": ");
	    return scanner.nextLine().trim();
	}

	public void mostrarMensaje(String mensaje) {
	    System.out.println(mensaje);
	}

	public int leerEntero(String mensaje) {
	    while (true) {
	        try {
	            String input = leerDato(mensaje);
	            return Integer.parseInt(input);
	        } catch (NumberFormatException e) {
	            mostrarMensaje("Por favor, ingrese un número entero válido.");
	        }
	    }
	}

	public double leerDouble(String mensaje) {
	    while (true) {
	        try {
	            String input = leerDato(mensaje);
	            return Double.parseDouble(input);
	        } catch (NumberFormatException e) {
	            mostrarMensaje("Por favor, ingrese un número válido.");
	        }
	    }
	}

}