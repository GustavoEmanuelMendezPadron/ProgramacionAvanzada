using System;
using System.Collections.ObjectModel;
using Microsoft.Maui.Controls;

namespace CafePOS
{
    public partial class MainPage : ContentPage
    {
        public class OrderItem
        {
            public string Name { get; set; }
            public int Quantity { get; set; }
        }

        private ObservableCollection<OrderItem> OrderItems = new();
        private double Total = 0;

        public MainPage()
        {
            InitializeComponent();
            OrderListView.ItemsSource = OrderItems;
        }

        private void OnAddToCartClicked(object sender, EventArgs e)
        {
            string selectedProduct = ProductPicker.SelectedItem?.ToString();
            string quantityText = QuantityEntry.Text;

            if (string.IsNullOrEmpty(selectedProduct) || !int.TryParse(quantityText, out int quantity))
            {
                DisplayAlert("Error", "Por favor, selecciona un producto y ingresa una cantidad válida.", "OK");
                return;
            }

            OrderItems.Add(new() { Name = selectedProduct, Quantity = quantity });
            CalculateTotal();
        }

        private void OnCheckoutClicked(object sender, EventArgs e)
        {
            if (OrderItems.Count == 0)
            {
                DisplayAlert("Error", "No hay productos en el carrito.", "OK");
                return;
            }

            DisplayAlert("Pedido Finalizado", $"Total a pagar: ${Total:F2}", "OK");
            OrderItems.Clear();
            Total = 0;
            UpdateTotalLabel();
        }

        private void CalculateTotal()
        {
            Total = 0;
            foreach (var item in OrderItems)
            {
                Total += item.Quantity * 2.5; // Precio fijo de $2.50 por producto
            }
            UpdateTotalLabel();
        }

        private void UpdateTotalLabel()
        {
            TotalLabel.Text = $"Total: ${Total:F2}";
        }
    }
}