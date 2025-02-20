using System;
using Microsoft.Maui.Controls;

namespace LoanAssistantMAUI
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private void OnComputeClicked(object sender, EventArgs e)
        {
            try
            {
                double balance = double.Parse(balanceEntry.Text);
                double interest = double.Parse(interestEntry.Text) / 1200;
                int months = int.Parse(monthsEntry.Text);

                double factor = Math.Pow(1 + interest, months);
                double payment = balance * interest * factor / (factor - 1);

                paymentEntry.Text = payment.ToString("0.00");

                // Mostrar análisis del préstamo
                analysisEditor.Text = $"Saldo del Préstamo: ${balance}\n" +
                                      $"Tasa de Interés: {interest * 1200}%\n" +
                                      $"Número de Pagos: {months}\n" +
                                      $"Pago Mensual: ${payment:0.00}\n" +
                                      $"Pago Total: ${payment * months:0.00}\n" +
                                      $"Interés Total Pagado: ${(payment * months) - balance:0.00}";

                newLoanButton.IsEnabled = true;
            }
            catch (Exception)
            {
                DisplayAlert("Error", "Por favor, ingrese valores numéricos válidos.", "OK");
            }
        }

        private void OnResetClicked(object sender, EventArgs e)
        {
            balanceEntry.Text = "";
            interestEntry.Text = "";
            monthsEntry.Text = "";
            paymentEntry.Text = "";
            analysisEditor.Text = "";
            newLoanButton.IsEnabled = false;
        }

        private void OnExitClicked(object sender, EventArgs e)
        {
            System.Diagnostics.Process.GetCurrentProcess().Kill(); // Cierra la app
        }
    }
}
