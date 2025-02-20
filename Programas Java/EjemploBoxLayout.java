package tarea02;

import javax.swing.*;

public class EjemploBoxLayout {
 public static void main(String[] args) {
    
     JFrame frame = new JFrame("Ejemplo BoxLayout");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 200);

     
     JPanel panel = new JPanel();
     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

     
     for (int i = 1; i <= 8; i++) {
         panel.add(new JButton("Botón " + i));
     }

     
     frame.add(panel);


     frame.setVisible(true);
 }
}