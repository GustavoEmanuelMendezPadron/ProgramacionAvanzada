package Actual;

public class Venta extends ItemVenta { 
	private String ticketId; 
	private boolean aplicaImpuestos;
	public Venta(String ticketId, String codigo, String nombre, double precio, int cantidad, boolean aplicaImpuestos) {
	    super(codigo, nombre, precio, cantidad);
	    this.ticketId = ticketId;
	    this.aplicaImpuestos = aplicaImpuestos;
	}

	public String getTicketId() {
	    return ticketId;
	}

	public boolean isAplicaImpuestos() {
	    return aplicaImpuestos;
	}

	public double getTotal() {
	    return precio * cantidad;
	}

	@Override
	public String toString() {
	   
	    String mensajeImpuesto = aplicaImpuestos ? "El producto tiene impuestos." : "El producto no tiene impuestos.";
	    return String.format("Venta [Ticket: %s] %s - Cantidad: %d, Total: %.2f. %s", 
	            ticketId, super.toString(), cantidad, getTotal(), mensajeImpuesto);
	}

}
