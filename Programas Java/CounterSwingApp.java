package tarea02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterSwingApp {
    public static void main(String[] args) {
        // Crear ventana principal
        JFrame frame = new JFrame("Contador de Clics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Crear etiquetas y botón
        JLabel counterLabel = new JLabel("Clics: 0", SwingConstants.CENTER);
        counterLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JButton clickButton = new JButton("Haz Clic");

        // Lógica del contador
        final int[] count = {0}; // Array para que sea modificable dentro del ActionListener
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count[0]++;
                counterLabel.setText("Clics: " + count[0]);
            }
        });

        // Añadir componentes a la ventana
        frame.add(counterLabel, BorderLayout.CENTER);
        frame.add(clickButton, BorderLayout.SOUTH);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
