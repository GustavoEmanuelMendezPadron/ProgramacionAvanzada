package ejercicio_unidad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserFormApp {
    private JFrame frame;
    private JPanel mainPanel, formPanel, preferencesPanel;
    private JButton showFormButton, submitButton, preferencesButton;
    private JTextField nameField, occupationField, userField;
    private JPasswordField passwordField;
    private JComboBox<String> ageComboBox, employmentComboBox;
    private JCheckBox usCitizenCheckBox;
    private JRadioButton maleRadio, femaleRadio;
    private JTextArea displayArea;

    public UserFormApp() {
        frame = new JFrame("User Information Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 240, 255));
        
        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("User Details"));
        formPanel.setBackground(Color.WHITE);
        formPanel.setVisible(false);
        
        showFormButton = createStyledButton("Show Form");
        submitButton = createStyledButton("Submit");
        preferencesButton = createStyledButton("Preferences");
        
        nameField = new JTextField(15);
        occupationField = new JTextField(15);
        userField = new JTextField(15);
        passwordField = new JPasswordField(15);
        
        ageComboBox = new JComboBox<>(new String[]{"Under 18", "18 to 65", "65 or over"});
        employmentComboBox = new JComboBox<>(new String[]{"Employed", "Unemployed", "Student"});
        
        usCitizenCheckBox = new JCheckBox();
        
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        
        formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Occupation:"), gbc);
        gbc.gridx = 1;
        formPanel.add(occupationField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        formPanel.add(ageComboBox, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Employment:"), gbc);
        gbc.gridx = 1;
        formPanel.add(employmentComboBox, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("US Citizen:"), gbc);
        gbc.gridx = 1;
        formPanel.add(usCitizenCheckBox, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        formPanel.add(maleRadio, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        formPanel.add(femaleRadio, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        formPanel.add(submitButton, gbc);
        
        showFormButton.addActionListener(e -> formPanel.setVisible(true));
        submitButton.addActionListener(e -> saveData());
        preferencesButton.addActionListener(e -> showPreferences());
        
        mainPanel.add(showFormButton, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);
        mainPanel.add(preferencesButton, BorderLayout.WEST);
        
        frame.setJMenuBar(createMenuBar());
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(100, 150, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        return button;
    }
    
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        
        JMenu windowMenu = new JMenu("Window");
        JMenuItem showFormItem = new JMenuItem("Show Form");
        showFormItem.addActionListener(e -> formPanel.setVisible(true));
        windowMenu.add(showFormItem);
        
        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        return menuBar;
    }
    
    private void showPreferences() {
        preferencesPanel = new JPanel(new GridBagLayout());
        preferencesPanel.setBorder(BorderFactory.createTitledBorder("Preferences"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        preferencesPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        preferencesPanel.add(userField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        preferencesPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        preferencesPanel.add(passwordField, gbc);
        
        int result = JOptionPane.showConfirmDialog(frame, preferencesPanel, "Preferences", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(frame, "Preferences saved!");
        }
    }
    
    private void saveData() {
        String data = "Name: " + nameField.getText() + "\n" +
                      "Occupation: " + occupationField.getText() + "\n" +
                      "Age: " + ageComboBox.getSelectedItem() + "\n" +
                      "Employment: " + employmentComboBox.getSelectedItem() + "\n" +
                      "US Citizen: " + (usCitizenCheckBox.isSelected() ? "Yes" : "No") + "\n" +
                      "Gender: " + (maleRadio.isSelected() ? "Male" : "Female") + "\n";
        displayArea.setText(data);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserFormApp::new);
    }
}
