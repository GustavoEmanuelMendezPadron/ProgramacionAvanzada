package tarea02;

import javax.swing.*;
import java.awt.*;


public class EjemploCardLayout {
 public static void main(String[] args) {
     
     JFrame frame = new JFrame("Ejemplo CardLayout");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 200);


     CardLayout cardLayout = new CardLayout();
     JPanel panel = new JPanel(cardLayout);


     for (int i = 1; i <= 3; i++) {
         panel.add(new JLabel("Tarjeta " + i, SwingConstants.CENTER), "Card" + i);
     }

  
     JPanel buttonPanel = new JPanel();
     JButton nextButton = new JButton("Siguiente");
     JButton prevButton = new JButton("Anterior");

     buttonPanel.add(prevButton);
     buttonPanel.add(nextButton);

  
     nextButton.addActionListener(e -> cardLayout.next(panel));
     prevButton.addActionListener(e -> cardLayout.previous(panel));

     frame.setLayout(new BorderLayout());
     frame.add(panel, BorderLayout.CENTER);
     frame.add(buttonPanel, BorderLayout.SOUTH);

  
     frame.setVisible(true);
 }
}
