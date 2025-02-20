package Actual;

import java.util.ArrayList; 
import java.util.List; 
import java.util.function.Predicate;

public class GenericDAO<T> { 
private List<T> datos;

public GenericDAO() {
    datos = new ArrayList<>();
}

public void agregar(T item) {
    datos.add(item);
}

public boolean eliminar(T item) {
    return datos.remove(item);
}

public List<T> listar() {
    return datos;
}

public T buscar(Predicate<T> predicate) {
    for (T item : datos) {
        if (predicate.test(item)) {
            return item;
        }
    }
    return null;
}

}