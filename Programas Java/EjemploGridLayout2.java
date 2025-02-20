package tarea02;


import javax.swing.*;
import java.awt.*;

public class EjemploGridLayout2 {
 public static void main(String[] args) {     
     JFrame frame = new JFrame("Ejemplo GridLayout");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 200);

     
     frame.setLayout(new GridLayout(2, 4, 5, 5));

     
     for (int i = 1; i <= 8; i++) {
         frame.add(new JButton("Botón " + i));
     }

     
     frame.setVisible(true);
 }
}
