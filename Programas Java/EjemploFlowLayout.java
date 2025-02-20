package tarea02;

import javax.swing.*;
import java.awt.*;

public class EjemploFlowLayout {
 public static void main(String[] args) {
     
     JFrame frame = new JFrame("Ejemplo FlowLayout");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 200);

     
     frame.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

     
     for (int i = 1; i <= 8; i++) {
         frame.add(new JButton("Botón " + i));
     }

     
     frame.setVisible(true);
 }
}