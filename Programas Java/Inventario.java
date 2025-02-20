package Actual;

import java.util.ArrayList; import java.util.List;
public class Inventario { private List<Producto> productos;
public Inventario() {
    this.productos = new ArrayList<>();
}

public void agregarProducto(Producto producto) {
    productos.add(producto);
}

public boolean eliminarProducto(String codigo) {
    Producto prod = buscarProducto(codigo);
    if (prod != null) {
        return productos.remove(prod);
    }
    return false;
}

public Producto buscarProducto(String codigo) {
    for (Producto p : productos) {
        if (p.getCodigo().equals(codigo)) {
            return p;
        }
    }
    return null;
}

public List<Producto> listarProductos() {
    return productos;
}

public boolean agregarStock(String codigo, int cantidad) {
    Producto p = buscarProducto(codigo);
    if (p != null) {
        p.incrementarStock(cantidad);
        return true;
    }
    return false;
}

public boolean reducirStock(String codigo, int cantidad) {
    Producto p = buscarProducto(codigo);
    if (p != null) {
        return p.reducirStock(cantidad);
    }
    return false;
}

}