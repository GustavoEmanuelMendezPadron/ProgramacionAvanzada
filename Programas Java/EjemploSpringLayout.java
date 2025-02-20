package tarea02;

import javax.swing.*;

public class EjemploSpringLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo SpringLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");
        JButton button3 = new JButton("Botón 3");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        layout.putConstraint(SpringLayout.WEST, button1, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, button1, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, button2, 20, SpringLayout.EAST, button1);
        layout.putConstraint(SpringLayout.NORTH, button2, 0, SpringLayout.NORTH, button1);

        layout.putConstraint(SpringLayout.WEST, button3, 0, SpringLayout.WEST, button1);
        layout.putConstraint(SpringLayout.NORTH, button3, 20, SpringLayout.SOUTH, button1);

        frame.add(panel);
        frame.setVisible(true);
    }
}
