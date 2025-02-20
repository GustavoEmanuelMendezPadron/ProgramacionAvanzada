package tarea02;
//Elaborado por Mendez Padron Gustavo Emanuel
import javax.swing.*;

public class EjemploCampoTexto {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JTextField");
        frame.setSize(300, 200);
        frame.setLayout(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(50, 50, 200, 30);


        frame.add(campoTexto);

        frame.setVisible(true);
    }
}
