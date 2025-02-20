package FLASHCARDS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Flashcard {
    String question;
    String answer;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}

public class FlashcardsApp {
    private JFrame frame;
    private JTextArea questionArea;
    private JTextField answerField;
    private JButton showAnswerButton, nextButton;
    private JLabel resultLabel;
    private ArrayList<Flashcard> flashcards;
    private int currentIndex = 0;

    public FlashcardsApp() {
        flashcards = new ArrayList<>();
        loadFlashcards();
        
        frame = new JFrame("Flashcards App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new BorderLayout());
        
        questionArea = new JTextArea(5, 30);
        questionArea.setEditable(false);
        frame.add(new JScrollPane(questionArea), BorderLayout.NORTH);
        
        answerField = new JTextField();
        frame.add(answerField, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        showAnswerButton = new JButton("Verificar Respuesta");
        nextButton = new JButton("Siguiente");
        resultLabel = new JLabel();
        
        buttonPanel.add(showAnswerButton);
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(resultLabel, BorderLayout.EAST);
        
        showAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
        
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextFlashcard();
            }
        });
        
        showFlashcard();
        frame.setVisible(true);
    }
    
    private void loadFlashcards() {
        flashcards.add(new Flashcard("¿Cuál es la capital de Francia?", "París"));
        flashcards.add(new Flashcard("¿Cuántos planetas hay en el sistema solar?", "8"));
        flashcards.add(new Flashcard("¿Quién escribió 'Don Quijote de la Mancha'?", "Miguel de Cervantes"));
        flashcards.add(new Flashcard("¿Cuál es el resultado de 7x8?", "56"));
        flashcards.add(new Flashcard("¿En qué año llegó el hombre a la luna?", "1969"));
        flashcards.add(new Flashcard("¿Cuál es el símbolo químico del oro?", "Au"));
        flashcards.add(new Flashcard("¿Quién pintó la Mona Lisa?", "Leonardo da Vinci"));
        flashcards.add(new Flashcard("¿Cuál es el idioma más hablado en el mundo?", "Inglés"));
    }
    
    private void showFlashcard() {
        if (currentIndex < flashcards.size()) {
            questionArea.setText(flashcards.get(currentIndex).question);
            answerField.setText("");
            resultLabel.setText("");
        } else {
            questionArea.setText("¡Has terminado todas las tarjetas!");
            answerField.setEnabled(false);
            showAnswerButton.setEnabled(false);
            nextButton.setEnabled(false);
        }
    }
    
    private void checkAnswer() {
        String userAnswer = answerField.getText().trim();
        String correctAnswer = flashcards.get(currentIndex).answer;
        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            resultLabel.setText("Correcto!");
        } else {
            resultLabel.setText("Incorrecto. Respuesta: " + correctAnswer);
        }
    }
    
    private void nextFlashcard() {
        currentIndex++;
        showFlashcard();
    }
    
    public static void main(String[] args) {
        new FlashcardsApp();
    }
}
