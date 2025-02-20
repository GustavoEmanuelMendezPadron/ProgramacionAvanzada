using Microsoft.Maui.Controls;
using MiAplicacion.App.Models;
using MiAplicacion.App.Services;
using System.Collections.ObjectModel;

namespace MiAplicacion.App
{
    public partial class MainPage : ContentPage
    {
        private readonly RestService _restService;
        public ObservableCollection<TodoItem> TodoItems { get; set; }

        public MainPage()
        {
            InitializeComponent();
            _restService = new RestService();
            TodoItems = new ObservableCollection<TodoItem>();
            TodoItemsCollectionView.ItemsSource = TodoItems;
        }

        // Evento del botón para cargar los datos
        private async void OnLoadTodoItemsClicked(object sender, EventArgs e)
        {
            var items = await _restService.GetTodoItemsAsync();
            TodoItems.Clear();
            foreach (var item in items)
            {
                TodoItems.Add(item);
            }
        }
    }
}
