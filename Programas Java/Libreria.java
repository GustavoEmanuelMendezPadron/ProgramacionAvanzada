package Actual;

import java.io.IOException; 
import java.util.ArrayList; 
import java.util.List;

public class Libreria { 
	private Inventario inventario; 
	private GenericDAO<Venta> ventasDAO; 
	private InterfazUsuario ui; 
	private PersistenciaDatos<Producto> 
	persistenciaProductos; 
	private PersistenciaDatos<Venta> persistenciaVentas;
	
	
	public Libreria() {
	    inventario = new Inventario();
	    ventasDAO = new GenericDAO<>();
	    ui = new InterfazUsuario();
	    persistenciaProductos = new PersistenciaArchivos<>(Producto.class);
	    persistenciaVentas = new PersistenciaArchivos<>(Venta.class);
	    cargarDatos();
	}

	private void cargarDatos() {
	    try {
	        List<Producto> productosCargados = persistenciaProductos.cargar("data/productos.json");
	        if (productosCargados.isEmpty()) {
	            
	            inventario.agregarProducto(new Producto("001", "Arroz 1kg", 35.0, 10, false));
	            inventario.agregarProducto(new Producto("002", "Azúcar 1kg", 25.0, 10, true));
	            inventario.agregarProducto(new Producto("003", "Harina 1kg", 28.0, 10, false));
	            inventario.agregarProducto(new Producto("004", "Aceite 1L", 50.0, 10, true));
	            inventario.agregarProducto(new Producto("005", "Leche 1L", 35.0, 10, false));
	        } else {
	            for (Producto p : productosCargados) {
	                inventario.agregarProducto(p);
	            }
	        }
	        
	        List<Venta> ventasCargadas = persistenciaVentas.cargar("data/ventas.json");
	        if (ventasCargadas != null) {
	            for (Venta v : ventasCargadas) {
	                ventasDAO.agregar(v);
	            }
	        }
	    } catch (IOException e) {
	        ui.mostrarMensaje("Error al cargar datos: " + e.getMessage());
	    }
	}

	private void guardarDatos() {
	    try {
	        persistenciaProductos.guardar(inventario.listarProductos(), "data/productos.json");
	        persistenciaVentas.guardar(ventasDAO.listar(), "data/ventas.json");
	    } catch (IOException e) {
	        ui.mostrarMensaje("Error al guardar datos: " + e.getMessage());
	    }
	}

	public void iniciar() {
	    String opcion;
	    do {
	        ui.mostrarMensaje("\n=== MENÚ PRINCIPAL ===");
	        ui.mostrarMensaje("1. Gestión de Productos");
	        ui.mostrarMensaje("2. Punto de Venta");
	        ui.mostrarMensaje("3. Gestión de Inventario");
	        ui.mostrarMensaje("4. Reporte de Ventas");
	        ui.mostrarMensaje("5. Salir");
	        opcion = ui.leerDato("Seleccione una opción");
	        switch(opcion) {
	            case "1":
	                menuProductos();
	                break;
	            case "2":
	                puntoVenta();
	                break;
	            case "3":
	                menuInventario();
	                break;
	            case "4":
	                reporteVentas();
	                break;
	            case "5":
	                ui.mostrarMensaje("Saliendo del sistema...");
	                guardarDatos();
	                break;
	            default:
	                ui.mostrarMensaje("Opción no válida. Intente de nuevo.");
	        }
	    } while (!opcion.equals("5"));
	}

	private void menuProductos() {
	    String opcion;
	    do {
	        ui.mostrarMensaje("\n--- Gestión de Productos ---");
	        ui.mostrarMensaje("1. Listar Productos");
	        ui.mostrarMensaje("2. Agregar Producto");
	        ui.mostrarMensaje("3. Eliminar Producto");
	        ui.mostrarMensaje("4. Volver al Menú Principal");
	        opcion = ui.leerDato("Seleccione una opción");
	        switch(opcion) {
	            case "1":
	                listarProductos();
	                break;
	            case "2":
	                agregarProducto();
	                break;
	            case "3":
	                eliminarProducto();
	                break;
	            case "4":
	                ui.mostrarMensaje("Regresando al menú principal...");
	                break;
	            default:
	                ui.mostrarMensaje("Opción no válida.");
	        }
	    } while (!opcion.equals("4"));
	}

	private void listarProductos() {
	    ui.mostrarMensaje("\nLista de Productos:");
	    for (Producto p : inventario.listarProductos()) {
	        ui.mostrarMensaje(p.toString());
	    }
	}

	
	private void agregarProducto() {
	    String codigo = ui.leerDato("Ingrese el código del producto");
	    String nombre = ui.leerDato("Ingrese el nombre del producto");
	    double precio = ui.leerDouble("Ingrese el precio");
	    int stock = ui.leerEntero("Ingrese el stock");
	    String respuesta = ui.leerDato("¿El producto lleva IVA e IEPS? (S/N)").toUpperCase();
	    boolean aplicaImpuestos = respuesta.equals("S");
	    Producto nuevoProducto = new Producto(codigo, nombre, precio, stock, aplicaImpuestos);
	    inventario.agregarProducto(nuevoProducto);
	    ui.mostrarMensaje("Producto agregado exitosamente.");
	}

	private void eliminarProducto() {
	    String codigo = ui.leerDato("Ingrese el código del producto a eliminar");
	    if (inventario.eliminarProducto(codigo)) {
	        ui.mostrarMensaje("Producto eliminado.");
	    } else {
	        ui.mostrarMensaje("Producto no encontrado.");
	    }
	}

	
	private void puntoVenta() {
	    ui.mostrarMensaje("\n--- Punto de Venta ---");
	    String ticketId = generarTicketId();
	    List<Venta> ventasActuales = new ArrayList<>();
	    String opcion;
	    do {
	        ui.mostrarMensaje("\nTicket No: " + ticketId);
	        ui.mostrarMensaje("1. Agregar Producto a la Venta");
	        ui.mostrarMensaje("2. Finalizar Venta");
	        ui.mostrarMensaje("3. Cancelar Venta");
	        opcion = ui.leerDato("Seleccione una opción");
	        switch(opcion) {
	            case "1":
	                agregarProductoVenta(ticketId, ventasActuales);
	                break;
	            case "2":
	                finalizarVenta(ticketId, ventasActuales);
	                return;
	            case "3":
	                ui.mostrarMensaje("Venta cancelada.");
	                return;
	            default:
	                ui.mostrarMensaje("Opción no válida.");
	        }
	    } while (true);
	}

	private String generarTicketId() {
	    int num = ventasDAO.listar().size() + 1;
	    return String.format("%03d", num);
	}

	
	private void agregarProductoVenta(String ticketId, List<Venta> ventasActuales) {
	    String codigo = ui.leerDato("Ingrese el código del producto");
	    Producto p = inventario.buscarProducto(codigo);
	    if (p == null) {
	        ui.mostrarMensaje("Producto no encontrado.");
	        return;
	    }
	    int cantidad = ui.leerEntero("Ingrese la cantidad");
	    if (p.getStock() < cantidad) {
	        ui.mostrarMensaje("Stock insuficiente.");
	        return;
	    }
	    if (inventario.reducirStock(codigo, cantidad)) {
	      
	        Venta venta = new Venta(ticketId, p.getCodigo(), p.getNombre(), p.getPrecio(), cantidad, p.isAplicaImpuestos());
	        ventasActuales.add(venta);
	        ui.mostrarMensaje("Producto agregado a la venta.");
	        double iva = p.calcularIVA();
	        double ieps = p.calcularIEPS();
	        if (p.isAplicaImpuestos()) {
	            ui.mostrarMensaje("El producto tiene impuestos. IVA (16%): " + iva + ", IEPS (8%): " + ieps);
	        } else {
	            ui.mostrarMensaje("El producto no tiene impuestos.");
	        }
	    } else {
	        ui.mostrarMensaje("No se pudo reducir el stock.");
	    }
	}




	private void finalizarVenta(String ticketId, List<Venta> ventasActuales) {
	    if (ventasActuales.isEmpty()) {
	        ui.mostrarMensaje("No se han agregado productos a la venta.");
	        return;
	    }
	    double subtotal = 0;
	    for (Venta v : ventasActuales) {
	        subtotal += v.getTotal();
	    }
	    double ivaTotal = subtotal * 0.16;
	    double total = subtotal + ivaTotal;
	    ui.mostrarMensaje("\n=== Ticket de Venta ===");
	    ui.mostrarMensaje("Ticket No: " + ticketId);
	    for (Venta v : ventasActuales) {
	        ui.mostrarMensaje(v.toString());
	    }
	    ui.mostrarMensaje(String.format("Subtotal: %.2f", subtotal));
	    ui.mostrarMensaje(String.format("IVA (16%%): %.2f", ivaTotal));
	    ui.mostrarMensaje(String.format("Total: %.2f", total));
	    
	    for (Venta v : ventasActuales) {
	        ventasDAO.agregar(v);
	    }
	    ui.mostrarMensaje("Venta finalizada y registrada.");
	}

	private void menuInventario() {
	    String opcion;
	    do {
	        ui.mostrarMensaje("\n--- Gestión de Inventario ---");
	        ui.mostrarMensaje("1. Listar Inventario");
	        ui.mostrarMensaje("2. Agregar Stock a un Producto");
	        ui.mostrarMensaje("3. Volver al Menú Principal");
	        opcion = ui.leerDato("Seleccione una opción");
	        switch(opcion) {
	            case "1":
	                listarProductos();
	                break;
	            case "2":
	                String codigo = ui.leerDato("Ingrese el código del producto");
	                int cantidad = ui.leerEntero("Ingrese la cantidad a agregar");
	                if (inventario.agregarStock(codigo, cantidad)) {
	                    ui.mostrarMensaje("Stock actualizado.");
	                } else {
	                    ui.mostrarMensaje("Producto no encontrado.");
	                }
	                break;
	            case "3":
	                ui.mostrarMensaje("Regresando al menú principal...");
	                break;
	            default:
	                ui.mostrarMensaje("Opción no válida.");
	        }
	    } while (!opcion.equals("3"));
	}

	private void reporteVentas() {
	    ui.mostrarMensaje("\n--- Reporte de Ventas ---");
	    List<Venta> todasVentas = ventasDAO.listar();
	    if (todasVentas.isEmpty()) {
	        ui.mostrarMensaje("No hay ventas registradas.");
	    } else {
	        for (Venta v : todasVentas) {
	            ui.mostrarMensaje(v.toString());
	        }
	    }
	}

}

