
package controlador;

import modelo.BaseDeDatos; // Importa el Modelo
import modelo.Producto;
import vista.InventarioVista; // Importa la Vista

public class ControladorInventario {
    private BaseDeDatos baseDatos; 
    private InventarioVista vista;

    // Constructor con Inyección de Dependencias 
    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

    public void iniciar() { // Bucle principal
        boolean salir = false;
        while (!salir) { // [cite: 101]
            int opcion = vista.mostrarMenu(); // Llama a la Vista para obtener opción 

            switch (opcion) { 
                case 1: // Agregar un nuevo producto
                    Producto nuevoProducto = vista.pedirDatosUsuario(); // 1. Pedir datos a Vista
                    baseDatos.agregarProducto(nuevoProducto); // 2. Guardar en Modelo 
                    vista.mostrarMensaje("Producto agregado correctamente."); // 3. Mostrar mensaje
                    break;
                case 2: // Buscar un producto por SKU
                    String skuBuscar = vista.pedirSku(); // 1. Pedir SKU a Vista
                    Producto productoEncontrado = baseDatos.buscarProductoSku(skuBuscar); // 2. Buscar en Modelo 
                    vista.mostrarProducto(productoEncontrado); // 3. Mostrar el resultado con Vista
                    break;
                case 3: // Mostrar todos los productos
                    vista.mostrarProductos(baseDatos.buscarTodos()); // Llama al Modelo y pasa lista a la Vista
                    break;
                case 4: // Eliminar un producto
                    String skuEliminar = vista.pedirSku(); // 1. Pedir SKU a Vista
                    boolean eliminado = baseDatos.eliminarProducto(skuEliminar); // 2. Eliminar en Modelo
                    String mensaje = eliminado ? "Producto eliminado correctamente." : "Error: Producto no encontrado para eliminar.";
                    vista.mostrarMensaje(mensaje); // 3. Mostrar mensaje
                    break;
                case 5: // Salir 
                    vista.mostrarMensaje("Saliendo de la aplicación. ¡Hasta pronto!");
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }
}