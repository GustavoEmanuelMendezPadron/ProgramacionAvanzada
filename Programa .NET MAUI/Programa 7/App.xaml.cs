using Microsoft.Maui.Controls;

namespace CafePOS
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();
            MainPage = new AppShell();
        }
    }
}