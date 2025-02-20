package tarea0;
import javax.swing.*;
import java.awt.*;

public class tarea0 {
    public static void main(String[] args) {
            
    	JFrame frame = new JFrame("Tarea 0 - Diseño Visual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

       
        JLabel titleLabel = new JLabel("Reloj Digital");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

       
        JPanel examplePanel = new JPanel();
        examplePanel.setLayout(new GridLayout(2, 2, 10, 10));

        
        Color softBlue = new Color(173, 216, 230);
        Color softGreen = new Color(144, 238, 144);
        Color softYellow = new Color(255, 255, 224);
        Color softOrange = new Color(255, 204, 153);

        JButton button1 = new JButton("Iniciar");
        button1.setBackground(softBlue);
        button1.setOpaque(true);
        button1.setBorderPainted(false);

        JButton button2 = new JButton("Parar");
        button2.setBackground(softGreen);
        button2.setOpaque(true);
        button2.setBorderPainted(false);

        JButton button3 = new JButton("Reiniciar");
        button3.setBackground(softYellow);
        button3.setOpaque(true);
        button3.setBorderPainted(false);

        JButton button4 = new JButton("Configuración");
        button4.setBackground(softOrange);
        button4.setOpaque(true);
        button4.setBorderPainted(false);

        examplePanel.add(button1);
        examplePanel.add(button2);
        examplePanel.add(button3);
        examplePanel.add(button4);

        mainPanel.add(examplePanel);

        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        
        JLabel timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Courier", Font.PLAIN, 36));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(timeLabel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
