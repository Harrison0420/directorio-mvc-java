
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Clase Modelo que simula la Base de Datos y la lógica de negocio.
 */
public class BaseDeDatos {

    // Atributo privado: Lista de productos (inicializada)
    private List<Producto> productos = new ArrayList<>();

    // Esta clase no tiene NINGÚN System.out.println() ni Scanner

    /**
     * Añade un producto a la lista. 
     */
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    /**
     * Busca en la lista por SKU (ignorando mayúsculas/minúsculas).
     * Retorna el Producto si lo encuentra, o null si no.
     */
    public Producto buscarProductoSku(String sku) {
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p; 
            }
        }
        return null; // No se encontró 
    }

    /**
     * Retorna la lista completa de productos.
     */
    public List<Producto> buscarTodos() {
        return new ArrayList<>(productos); 
        // Retornamos una copia para evitar modificación externa
    }

    /**
     * Elimina un producto basado en el SKU.
     * Retorna true si lo eliminó, false si no lo encontró.
     */
    public boolean eliminarProducto(String sku) {
        Iterator<Producto> iterador = productos.iterator();
        while (iterador.hasNext()) {
            Producto p = iterador.next();
            if (p.getSku().equalsIgnoreCase(sku)) {
                iterador.remove(); // Elimina el producto de forma segura
                return true; // Éxito [cite: 74]
            }
        }
        return false; // No se encontró [cite: 75]
    }
}