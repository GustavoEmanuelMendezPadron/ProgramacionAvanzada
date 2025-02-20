using Microsoft.Maui.Controls;

namespace MauiApp1;

public partial class MainPage : ContentPage
{
    public MainPage()
    {
        InitializeComponent();
        CreateMenuBar();
    }

    private void CreateMenuBar()
    {
        ToolbarItems.Add(new ToolbarItem("Exit", null, () =>
        {
            Application.Current.Quit();
        }));
    }

    private void OnShowFormClicked(object sender, EventArgs e)
    {
        formFrame.IsVisible = !formFrame.IsVisible;
        btnShowForm.Text = formFrame.IsVisible ? "Hide Form" : "Show Form";
    }

    private void OnSubmitClicked(object sender, EventArgs e)
    {
        var gender = maleRadio.IsChecked ? "Male" :
                    femaleRadio.IsChecked ? "Female" : "Not specified";

        var data = $"Name: {nameEntry.Text}\n" +
                   $"Occupation: {occupationEntry.Text}\n" +
                   $"Age: {agePicker.SelectedItem}\n" +
                   $"Employment: {employmentPicker.SelectedItem}\n" +
                   $"US Citizen: {(usCitizenCheckBox.IsChecked ? "Yes" : "No")}\n" +
                   $"Gender: {gender}";

        displayEditor.Text = data;
    }
}