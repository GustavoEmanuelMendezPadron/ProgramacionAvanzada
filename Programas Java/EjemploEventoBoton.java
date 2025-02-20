package tarea02;
import javax.swing.*;
//Elaborado por Mendez Padron Gustavo Emanuel
import java.awt.event.*;

public class EjemploEventoBoton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo Evento JButton");
        frame.setSize(300, 200);
        frame.setLayout(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JButton boton = new JButton("Mostrar");
        boton.setBounds(50, 50, 100, 30);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(50, 100, 200, 30);

     
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Texto: " + campoTexto.getText());
            }
        });

        
        frame.add(boton);
        frame.add(campoTexto);

        frame.setVisible(true);
    }
}

