package FLASHCARDS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class LoanAssistant extends JFrame {
    private JTextField campoBalance, campoInteres, campoMeses, campoPago;
    private JTextArea areaAnalisis;
    private JButton botonCalcular, botonNuevo, botonSalir, botonModo;
    private boolean calcularPago = true;
    private static final Color AMARILLO_CLARO = new Color(255, 255, 128);

    public LoanAssistant() {
        setTitle("Asistente de Préstamos");
        setLayout(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Etiquetas
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Saldo del préstamo:"), gbc);
        gbc.gridy = 1;
        add(new JLabel("Tasa de interés (% anual):"), gbc);
        gbc.gridy = 2;
        add(new JLabel("Número de pagos:"), gbc);
        gbc.gridy = 3;
        add(new JLabel("Pago mensual:"), gbc);
        
        // Campos de texto
        gbc.gridx = 1; gbc.gridy = 0;
        campoBalance = new JTextField(10);
        add(campoBalance, gbc);
        gbc.gridy = 1;
        campoInteres = new JTextField(10);
        add(campoInteres, gbc);
        gbc.gridy = 2;
        campoMeses = new JTextField(10);
        add(campoMeses, gbc);
        gbc.gridy = 3;
        campoPago = new JTextField(10);
        campoPago.setEditable(false);
        campoPago.setBackground(AMARILLO_CLARO);
        add(campoPago, gbc);
        
        // Botones
        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 2;
        botonCalcular = new JButton("Calcular Pago Mensual");
        botonCalcular.addActionListener(e -> calcularPrestamo());
        add(botonCalcular, gbc);
        
        gbc.gridy = 5;
        botonNuevo = new JButton("Nuevo Análisis");
        botonNuevo.setEnabled(false);
        botonNuevo.addActionListener(e -> limpiarCampos());
        add(botonNuevo, gbc);
        
        gbc.gridy = 6;
        botonSalir = new JButton("Salir");
        botonSalir.addActionListener(e -> System.exit(0));
        add(botonSalir, gbc);
        
        gbc.gridx = 2; gbc.gridy = 2;
        botonModo = new JButton("X");
        botonModo.addActionListener(e -> cambiarModo());
        add(botonModo, gbc);
        
        // Área de Análisis
        gbc.gridx = 3; gbc.gridy = 0; gbc.gridheight = 4;
        areaAnalisis = new JTextArea(10, 25);
        areaAnalisis.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaAnalisis.setEditable(false);
        add(new JScrollPane(areaAnalisis), gbc);
        
        pack();
        setLocationRelativeTo(null);
    }

    private void calcularPrestamo() {
        double balance, interes, pago;
        int meses;
        
        try {
            balance = Double.parseDouble(campoBalance.getText());
            interes = Double.parseDouble(campoInteres.getText()) / 1200;
            
            if (calcularPago) {
                meses = Integer.parseInt(campoMeses.getText());
                double factor = Math.pow(1 + interes, meses);
                pago = balance * interes * factor / (factor - 1);
                campoPago.setText(new DecimalFormat("0.00").format(pago));
            } else {
                pago = Double.parseDouble(campoPago.getText());
                meses = (int) ((Math.log(pago) - Math.log(pago - balance * interes)) / Math.log(1 + interes));
                campoMeses.setText(String.valueOf(meses));
            }
            
            // Análisis del préstamo
            areaAnalisis.setText("Saldo del Préstamo: $" + balance + "\n");
            areaAnalisis.append("Tasa de Interés: " + interes * 1200 + "%\n");
            areaAnalisis.append("Número de Pagos: " + meses + "\n");
            areaAnalisis.append("Pago Mensual: $" + new DecimalFormat("0.00").format(pago) + "\n");
            areaAnalisis.append("Pago Total: $" + new DecimalFormat("0.00").format(pago * meses) + "\n");
            areaAnalisis.append("Interés Total Pagado: $" + new DecimalFormat("0.00").format(pago * meses - balance));
            
            botonCalcular.setEnabled(false);
            botonNuevo.setEnabled(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        campoPago.setText("");
        campoMeses.setText("");
        areaAnalisis.setText("");
        botonCalcular.setEnabled(true);
        botonNuevo.setEnabled(false);
    }

    private void cambiarModo() {
        calcularPago = !calcularPago;
        campoMeses.setEditable(calcularPago);
        campoPago.setEditable(!calcularPago);
        campoPago.setBackground(calcularPago ? AMARILLO_CLARO : Color.WHITE);
        campoMeses.setBackground(calcularPago ? Color.WHITE : AMARILLO_CLARO);
        botonCalcular.setText(calcularPago ? "Calcular Pago Mensual" : "Calcular Número de Pagos");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoanAssistant().setVisible(true));
    }
}
