package Actual;

public abstract class ItemVenta { 
	protected String codigo; 
	protected String nombre; 
	protected double precio; 
	protected int cantidad; 
	
	public ItemVenta(String codigo, String nombre, double precio, int cantidad) {
	    this.codigo = codigo;
	    this.nombre = nombre;
	    this.precio = precio;
	    this.cantidad = cantidad;
	}

	public String getCodigo() {
	    return codigo;
	}

	public String getNombre() {
	    return nombre;
	}

	public double getPrecio() {
	    return precio;
	}

	public int getCantidad() {
	    return cantidad;
	}

	public void setCantidad(int cantidad) {
	    this.cantidad = cantidad;
	}

	@Override
	public String toString() {
	    return String.format("%s - %s - %.2f - %d", codigo, nombre, precio, cantidad);
	}

}