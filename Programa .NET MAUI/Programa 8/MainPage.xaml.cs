namespace FlashcardsMaui;

public partial class MainPage : ContentPage
{
    private List<(string Question, string Answer)> flashcards;
    private int currentIndex = 0;

    public MainPage()
    {
        InitializeComponent();
        LoadFlashcards();
        ShowFlashcard();
    }

    private void LoadFlashcards()
    {
        flashcards = new()
        {
            ("¿Cuál es la capital de Francia?", "París"),
            ("¿Cuántos planetas hay en el sistema solar?", "8"),
            ("¿Quién escribió 'Don Quijote de la Mancha'?", "Miguel de Cervantes"),
            ("¿Cuál es el resultado de 7x8?", "56"),
            ("¿En qué año llegó el hombre a la luna?", "1969"),
            ("¿Cuál es el símbolo químico del oro?", "Au"),
            ("¿Quién pintó la Mona Lisa?", "Leonardo da Vinci"),
            ("¿Cuál es el idioma más hablado en el mundo?", "Inglés"),
        };
    }

    private void ShowFlashcard()
    {
        if (currentIndex < flashcards.Count)
        {
            QuestionLabel.Text = flashcards[currentIndex].Question;
            AnswerEntry.Text = "";
            ResultLabel.Text = "";
        }
        else
        {
            QuestionLabel.Text = "¡Has terminado todas las tarjetas!";
            AnswerEntry.IsEnabled = false;
            CheckButton.IsEnabled = false;
            NextButton.IsEnabled = false;
        }
    }

    private void CheckButton_Clicked(object sender, EventArgs e)
    {
        string userAnswer = AnswerEntry.Text.Trim();
        string correctAnswer = flashcards[currentIndex].Answer;

        if (userAnswer.Equals(correctAnswer, StringComparison.OrdinalIgnoreCase))
        {
            ResultLabel.Text = "¡Correcto!";
            ResultLabel.TextColor = Colors.Green;
        }
        else
        {
            ResultLabel.Text = $"Incorrecto. Respuesta: {correctAnswer}";
            ResultLabel.TextColor = Colors.Red;
        }
    }

    private void NextButton_Clicked(object sender, EventArgs e)
    {
        currentIndex++;
        ShowFlashcard();
    }
}
