using System;
using System.Windows.Forms;

namespace a2233336160_Tareas_Unidad01
{
    public class MainForm : Form
    {
        private Button calcularButton;
        private TextBox inputTextBox;

        public MainForm()
        {
            this.Text = "Tarea 02 - WinForms";
            this.Size = new System.Drawing.Size(400, 200);

            inputTextBox = new TextBox
            {
                Location = new System.Drawing.Point(50, 50),
                Width = 200
            };
            this.Controls.Add(inputTextBox);

            
            calcularButton = new Button
            {
                Text = "Calcular",
                Location = new System.Drawing.Point(50, 100),
                Width = 100
            };
            calcularButton.Click += CalcularButton_Click;
            this.Controls.Add(calcularButton);
        }

        private void CalcularButton_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Texto ingresado: " + inputTextBox.Text);
        }

        [STAThread]
        static void Main()
        {
            // Iniciar la aplicación
            Application.EnableVisualStyles();
            Application.Run(new MainForm());
        }
    }
}
