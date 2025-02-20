using System.Text.RegularExpressions;

namespace Phoneword;

public partial class MainPage : ContentPage
{
    string translatedNumber;

    public MainPage()
    {
        InitializeComponent();
    }

    private void OnTranslate(object sender, EventArgs e)
    {
        string enteredNumber = PhoneNumberText.Text;
        translatedNumber = Core.PhonewordTranslator.ToNumber(enteredNumber);

        if (!string.IsNullOrEmpty(translatedNumber))
        {
            CallButton.IsEnabled = true;
            CallButton.Text = $"Llamar a {translatedNumber}";
        }
        else
        {
            CallButton.IsEnabled = false;
            CallButton.Text = "Llamar";
        }
    }

    private async void OnCall(object sender, EventArgs e)
    {
        if (await this.DisplayAlert(
            "Llamar",
            $"¿Quiere llamar al número {translatedNumber}?",
            "Sí",
            "No"))
        {
            try
            {
                if (PhoneDialer.Default.IsSupported)
                    PhoneDialer.Default.Open(translatedNumber);
            }
            catch (Exception)
            {
                await DisplayAlert("Error", "No se puede realizar la llamada.", "OK");
            }
        }
    }
}
