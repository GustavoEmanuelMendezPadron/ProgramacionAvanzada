using System;
using Microsoft.Maui.Controls;

namespace UserFormMAUI
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private async void OnSubmitClicked(object sender, EventArgs e)
        {
            string name = NameEntry.Text;
            string gender = MaleRadio.IsChecked ? "Male" : (FemaleRadio.IsChecked ? "Female" : "Not selected");
            string age = AgePicker.SelectedItem?.ToString() ?? "Not selected";
            string occupation = OccupationEntry.Text;
            string employment = EmploymentPicker.SelectedItem?.ToString() ?? "Not selected";
            string citizenship = USCitizenCheckBox.IsChecked ? "Yes" : "No";

            string message = $"Name: {name}\n" +
                             $"Gender: {gender}\n" +
                             $"Age: {age}\n" +
                             $"Occupation: {occupation}\n" +
                             $"Employment: {employment}\n" +
                             $"US Citizen: {citizenship}";

            DisplayEditor.Text = message;

            await DisplayAlert("Form Submission", "Form submitted successfully!", "OK");
        }
    }
}
