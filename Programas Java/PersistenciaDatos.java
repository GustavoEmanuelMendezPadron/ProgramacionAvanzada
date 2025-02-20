package Actual;

import java.io.IOException; import java.util.List;

public interface PersistenciaDatos<T> { 
	void guardar(List<T> datos, String fileName) throws IOException; 
	List<T> cargar(String fileName) throws IOException; }