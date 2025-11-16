/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Producto;

public class InventarioVista {
    private Scanner scanner; // Tiene un Scanner como atributo [cite: 80]

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() { // [cite: 84]
        System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Buscar un producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar un producto");
        System.out.println("5. Salir"); // [cite: 52]
        System.out.print("Seleccione una opción: ");
        // Manejo básico de entrada, asume que el usuario ingresa un número
        return scanner.nextInt(); 
    }

    public Producto pedirDatosUsuario() { // [cite: 85]
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("SKU: ");
        String sku = scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Precio Unitario: ");
        double precio = scanner.nextDouble();
        
        return new Producto(nombre, sku, cantidad, precio); // Crea y retorna el objeto Producto
    }

    public String pedirSku() { // [cite: 86]
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el SKU: ");
        return scanner.nextLine();
    }

    public void mostrarProducto(Producto producto) { // [cite: 87, 88]
        if (producto != null) {
            System.out.println("-> Producto encontrado: " + producto.toString());
        } else {
            System.out.println("-> Producto no encontrado.");
        }
    }

    public void mostrarProductos(List<Producto> productos) { // [cite: 91, 92]
        if (productos.isEmpty()) {
            System.out.println("-> No hay productos registrados.");
            return;
        }
        System.out.println("\n--- LISTA COMPLETA DE PRODUCTOS ---");
        for (Producto p : productos) {
            System.out.println(p.toString()); // Usa el toString() del Modelo
        }
        System.out.println("-------------------------------------");
    }

    public void mostrarMensaje(String mensaje) { // [cite: 93]
        System.out.println("-> " + mensaje);
    }
}