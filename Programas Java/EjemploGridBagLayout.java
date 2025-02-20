package tarea02;

import javax.swing.*;
import java.awt.*;

public class EjemploGridBagLayout {
 public static void main(String[] args) {
    
     JFrame frame = new JFrame("Ejemplo GridBagLayout");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 200);

     
     frame.setLayout(new GridBagLayout());
     GridBagConstraints gbc = new GridBagConstraints();

     
     for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 2; j++) {
             gbc.gridx = i;
             gbc.gridy = j;
             gbc.insets = new Insets(5, 5, 5, 5);
             frame.add(new JButton("Botón (" + i + ", " + j + ")"), gbc);
         }
     }

    
     frame.setVisible(true);
 }
}
