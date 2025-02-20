package Crud;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {
    private JTextField txtBuscar;
    private JTextArea txtArea;
    private JButton btnCreate, btnRead, btnUpdate, btnDelete;

    public Vista() {
        // Configuración de la ventana
        setTitle("CRUD con MVC");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con el buscador
        JPanel panelSuperior = new JPanel();
        txtBuscar = new JTextField(20);
        panelSuperior.add(new JLabel("Buscar:"));
        panelSuperior.add(txtBuscar);

        // Área de texto con ScrollPane
        txtArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(txtArea);

        // Panel inferior con botones
        JPanel panelInferior = new JPanel();
        btnCreate = new JButton("Create");
        btnRead = new JButton("Read");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        
        panelInferior.add(btnCreate);
        panelInferior.add(btnRead);
        panelInferior.add(btnUpdate);
        panelInferior.add(btnDelete);

        // Agregamos los componentes a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    // Getters para acceder a los botones desde el controlador
    public JTextField getTxtBuscar() { return txtBuscar; }
    public JTextArea getTxtArea() { return txtArea; }
    public JButton getBtnCreate() { return btnCreate; }
    public JButton getBtnRead() { return btnRead; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnDelete() { return btnDelete; }
}
