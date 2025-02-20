package tarea02;

//Ejemplo de FlowLayout
import javax.swing.*;
import java.awt.*;

public class EjemploFlowLayout2 {
 public static void main(String[] args) {
     // Crear un JFrame
     JFrame frame = new JFrame("Ejemplo FlowLayout");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 200);

     // Establecer el layout FlowLayout
     frame.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

     // Agregar 8 componentes al JFrame
     for (int i = 1; i <= 8; i++) {
         frame.add(new JButton("Botón " + i));
     }

     // Hacer visible el frame
     frame.setVisible(true);
 }
}