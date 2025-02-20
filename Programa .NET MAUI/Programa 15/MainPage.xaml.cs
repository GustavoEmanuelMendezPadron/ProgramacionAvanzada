using Microsoft.Maui.Controls;
namespace a2233336160_Tareas_Unidad_01p2
{
  
        public partial class MainPage : ContentPage
        {
            public MainPage()
            {
                InitializeComponent();
            }

            private void OnCalcularClicked(object sender, EventArgs e)
            {
                DisplayAlert("Resultado", $"Texto ingresado: {InputEntry.Text}", "OK");
            }
        }
    }
