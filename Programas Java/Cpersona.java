package tarea02;

public class Cpersona {
private String nombre;
private String apellido;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}


public Cpersona(String nombre, String apellido) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
}

@Override
public String toString() {
	return "Cpersona [nombre=" + nombre + ", apellido=" + apellido + "\n";
}

}
