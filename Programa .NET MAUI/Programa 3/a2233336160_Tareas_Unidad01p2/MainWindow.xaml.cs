

using System.Windows;

namespace amatricula_tareas_unidad01
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void CalcularButton_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Texto ingresado: " + InputTextBox.Text);
        }
    }
}
