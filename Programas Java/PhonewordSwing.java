package tarea02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhonewordSwing {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Phoneword");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel inputLabel = new JLabel("Ingrese palabra o número:");
        JTextField inputField = new JTextField(20);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        
        JLabel resultLabel = new JLabel("Número traducido: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        JButton translateButton = new JButton("Traducir");
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String translatedNumber = translateToNumber(input);

                if (translatedNumber != null) {
                    resultLabel.setText("Número traducido: " + translatedNumber);
                } else {
                    resultLabel.setText("Entrada no válida.");
                }
            }
        });

    
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultLabel, BorderLayout.CENTER);
        frame.add(translateButton, BorderLayout.SOUTH);

        
        frame.setVisible(true);
    }

    private static String translateToNumber(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        StringBuilder number = new StringBuilder();
        String upperInput = input.toUpperCase();

        for (char c : upperInput.toCharArray()) {
            if (Character.isDigit(c) || c == ' ') {
                number.append(c);
            } else {
                int digit = getNumberForLetter(c);
                if (digit != -1) {
                    number.append(digit);
                } else {
                    return null; 
                }
            }
        }
        return number.toString();
    }

    private static int getNumberForLetter(char letter) {
        switch (letter) {
            case 'A': case 'B': case 'C': return 2;
            case 'D': case 'E': case 'F': return 3;
            case 'G': case 'H': case 'I': return 4;
            case 'J': case 'K': case 'L': return 5;
            case 'M': case 'N': case 'O': return 6;
            case 'P': case 'Q': case 'R': case 'S': return 7;
            case 'T': case 'U': case 'V': return 8;
            case 'W': case 'X': case 'Y': case 'Z': return 9;
            default: return -1;
        }
    }
}
