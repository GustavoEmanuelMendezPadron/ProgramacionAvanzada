package Actual;

import java.io.*; 
import java.util.ArrayList; 
import java.util.List; 
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder; 
import com.google.gson.reflect.TypeToken;

public class PersistenciaArchivos<T> implements PersistenciaDatos<T> { 
	private Class<T> clazz; private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	public PersistenciaArchivos(Class<T> clazz) {
	    this.clazz = clazz;
	}

	@Override
	public void guardar(List<T> datos, String fileName) throws IOException {
	    File archivo = new File(fileName);
	    File carpeta = archivo.getParentFile();
	    if (carpeta != null && !carpeta.exists()) {
	        carpeta.mkdirs();
	    }
	    if (fileName.endsWith(".json")) {
	        guardarJSON(datos, archivo);
	    } else if (fileName.endsWith(".csv")) {
	        guardarCSV(datos, archivo);
	    } else {
	        throw new IllegalArgumentException("Formato no soportado: " + fileName);
	    }
	}

	private void guardarJSON(List<T> datos, File archivo) throws IOException {
	    try (Writer writer = new FileWriter(archivo)) {
	        gson.toJson(datos, writer);
	    }
	}

	private void guardarCSV(List<T> datos, File archivo) throws IOException {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
	        for (T item : datos) {
	            if (item instanceof Producto) {
	                Producto p = (Producto) item;
	                writer.write(String.format("%s,%s,%.2f,%d,%b", p.getCodigo(), p.getNombre(), p.getPrecio(), p.getStock(), p.isAplicaImpuestos()));
	            } else if (item instanceof Venta) {
	                Venta v = (Venta) item;
	                
	                writer.write(String.format("%s,%s,%s,%.2f,%d,%b", v.getTicketId(), v.getCodigo(), v.getNombre(), v.getPrecio(), v.getCantidad(), v.isAplicaImpuestos()));
	            }
	            writer.newLine();
	        }
	    }
	}

	@Override
	public List<T> cargar(String fileName) throws IOException {
	    File archivo = new File(fileName);
	    if (!archivo.exists()) {
	        System.out.println("[AVISO] Archivo no encontrado: " + fileName);
	        return new ArrayList<>();
	    }
	    if (fileName.endsWith(".json")) {
	        return cargarJSON(archivo);
	    } else if (fileName.endsWith(".csv")) {
	        return cargarCSV(archivo);
	    } else {
	        throw new IllegalArgumentException("Formato no soportado: " + fileName);
	    }
	}

	private List<T> cargarJSON(File archivo) throws IOException {
	    try (Reader reader = new FileReader(archivo)) {
	        return gson.fromJson(reader, TypeToken.getParameterized(List.class, clazz).getType());
	    }
	}

	private List<T> cargarCSV(File archivo) throws IOException {
	    List<T> lista = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] partes = line.split(",");
	            if (clazz == Producto.class) {
	                boolean aplicaImpuestos = false;
	                if (partes.length >= 5) {
	                    aplicaImpuestos = Boolean.parseBoolean(partes[4].trim());
	                }
	                Producto p = new Producto(partes[0], partes[1], Double.parseDouble(partes[2]), Integer.parseInt(partes[3]), aplicaImpuestos);
	                lista.add(clazz.cast(p));
	            } else if (clazz == Venta.class) {
	                boolean aplicaImpuestos = false;
	                if (partes.length >= 6) {
	                    aplicaImpuestos = Boolean.parseBoolean(partes[5].trim());
	                }
	                Venta v = new Venta(partes[0], partes[1], partes[2], Double.parseDouble(partes[3]), Integer.parseInt(partes[4]), aplicaImpuestos);
	                lista.add(clazz.cast(v));
	            }
	        }
	    }
	    return lista;
	}

}