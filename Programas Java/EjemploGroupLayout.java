package tarea02;

import javax.swing.*;

public class EjemploGroupLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo GroupLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");
        JButton button3 = new JButton("Botón 3");

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(button1)
                .addGap(10)
                .addComponent(button2)
                .addGap(10)
                .addComponent(button3)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(button1)
                .addComponent(button2)
                .addComponent(button3)
        );

        frame.add(panel);
        frame.setVisible(true);
    }
}
