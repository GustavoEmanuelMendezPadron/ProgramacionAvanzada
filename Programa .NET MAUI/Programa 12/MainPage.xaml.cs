using Microsoft.Maui.Controls;
using Microsoft.Maui.Essentials;
using System;

namespace CheckConnectivityMaui
{
    public partial class MainPage : ContentPage
    {
        Label ConnectionStatusLabel;

        public MainPage()
        {
            InitializeComponent();
            ConnectionStatusLabel = new Label
            {
                HorizontalOptions = LayoutOptions.Center,
                VerticalOptions = LayoutOptions.Center,
                FontSize = 20
            };

            Content = new StackLayout
            {
                Children = { ConnectionStatusLabel }
            };

            CheckNetworkStatus();
            Connectivity.ConnectivityChanged += Connectivity_ConnectivityChanged;
        }

        private void CheckNetworkStatus()
        {
            var current = Connectivity.NetworkAccess;
            ConnectionStatusLabel.Text = current == NetworkAccess.Internet ? "Conectado a Internet" : "Sin conexión";
        }

        private void Connectivity_ConnectivityChanged(object sender, ConnectivityChangedEventArgs e)
        {
            CheckNetworkStatus();
        }
    }
}
