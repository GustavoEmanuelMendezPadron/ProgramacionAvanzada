package tarea02;
import javax.swing.*;
//Elaborado por Mendez Padron Gustavo Emanuel
public class EjemploBoton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JButton");
        frame.setSize(300, 200);
        frame.setLayout(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     
        JButton boton = new JButton("Calcular");
        boton.setBounds(50, 50, 100, 30); 

        
        frame.add(boton);

        frame.setVisible(true);
    }
}
