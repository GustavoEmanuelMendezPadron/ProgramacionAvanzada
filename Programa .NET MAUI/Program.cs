using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using MiAplicacion.Api.Models;
using System.Collections.Generic;
using System.Linq;

var builder = WebApplication.CreateBuilder(args);

// Agrega servicios necesarios para la API y Swagger (para documentación y prueba)
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configuración de Swagger en ambiente de desarrollo
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

// Simulación de una "base de datos" en memoria
List<TodoItem> todoItems = new List<TodoItem>
{
    new TodoItem { Id = 1, Title = "Comprar leche", IsComplete = false },
    new TodoItem { Id = 2, Title = "Llamar a Juan", IsComplete = true },
};

// Endpoint GET: Obtener todos los elementos
app.MapGet("/todoitems", () => todoItems);

// Endpoint GET: Obtener un elemento por id
app.MapGet("/todoitems/{id}", (int id) =>
{
    var item = todoItems.FirstOrDefault(t => t.Id == id);
    return item is not null ? Results.Ok(item) : Results.NotFound();
});

// Endpoint POST: Crear un nuevo elemento
app.MapPost("/todoitems", (TodoItem newItem) =>
{
    int newId = (todoItems.Count > 0) ? todoItems.Max(t => t.Id) + 1 : 1;
    newItem.Id = newId;
    todoItems.Add(newItem);
    return Results.Created($"/todoitems/{newItem.Id}", newItem);
});

// Endpoint PUT: Actualizar un elemento existente
app.MapPut("/todoitems/{id}", (int id, TodoItem updateItem) =>
{
    var item = todoItems.FirstOrDefault(t => t.Id == id);
    if (item is null)
        return Results.NotFound();

    item.Title = updateItem.Title;
    item.IsComplete = updateItem.IsComplete;
    return Results.Ok(item);
});

// Endpoint DELETE: Eliminar un elemento
app.MapDelete("/todoitems/{id}", (int id) =>
{
    var item = todoItems.FirstOrDefault(t => t.Id == id);
    if (item is null)
        return Results.NotFound();

    todoItems.Remove(item);
    return Results.Ok(item);
});

app.Run();
