

package Actual;

public class Producto extends ItemVenta implements ImpuestoAplicable {
	private int stock;
	private boolean aplicaImpuestos;
	// Indica si se deben aplicar IVA e IEPS

	public Producto(String codigo, String nombre, double precio, int stock, boolean aplicaImpuestos) {
	    super(codigo, nombre, precio, 0);
	    this.stock = stock;
	    this.aplicaImpuestos = aplicaImpuestos;
	}

	
	public boolean isAplicaImpuestos() {
	    return aplicaImpuestos;
	}

	public void setAplicaImpuestos(boolean aplicaImpuestos) {
	    this.aplicaImpuestos = aplicaImpuestos;
	}

	public int getStock() {
	    return stock;
	}

	public void setStock(int stock) {
	    this.stock = stock;
	}

	public void incrementarStock(int cantidad) {
	    this.stock += cantidad;
	}

	public boolean reducirStock(int cantidad) {
	    if (stock >= cantidad) {
	        stock -= cantidad;
	        return true;
	    }
	    return false;
	}

	@Override
	public double calcularIVA() {
	    
	    return aplicaImpuestos ? precio * 0.16 : 0;
	}

	@Override
	public double calcularIEPS() {
	   
	    return aplicaImpuestos ? precio * 0.08 : 0;
	}

	@Override
	public String toString() {
	    return String.format("Producto: %s - %s - Precio: %.2f, Stock: %d, Aplica Impuestos: %b", 
	                          codigo, nombre, precio, stock, aplicaImpuestos);
	}

}