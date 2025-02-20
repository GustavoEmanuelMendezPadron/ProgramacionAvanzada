using Microsoft.Maui.Controls;

namespace MiAplicacion.App
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            // Se establece MainPage. Puedes usar NavigationPage si lo deseas.
            MainPage = new NavigationPage(new MainPage());
        }
    }
}
