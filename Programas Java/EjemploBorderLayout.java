package tarea02;


import javax.swing.*;
import java.awt.*;

public class EjemploBorderLayout {
 public static void main(String[] args) {
     
     JFrame frame = new JFrame("Ejemplo BorderLayout");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 200);

     
     frame.setLayout(new BorderLayout(5, 5));

     
     frame.add(new JButton("Norte"), BorderLayout.NORTH);
     frame.add(new JButton("Sur"), BorderLayout.SOUTH);
     frame.add(new JButton("Este"), BorderLayout.EAST);
     frame.add(new JButton("Oeste"), BorderLayout.WEST);
     frame.add(new JButton("Centro"), BorderLayout.CENTER);

     
     frame.setVisible(true);
 }
}
