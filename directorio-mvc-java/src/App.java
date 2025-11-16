import controlador.ControladorInventario;
import modelo.BaseDeDatos;
import vista.InventarioVista;

public class App { 
    
    public static void main(String[] args) {
        
        // 1. Crear la instancia del Modelo 
        BaseDeDatos modelo = new BaseDeDatos();

        // 2. Crear la instancia de la Vista
        InventarioVista vista = new InventarioVista();

        // 3. Crear la instancia del Controlador, inyectando el Modelo y la Vista [cite: 121]
        ControladorInventario controlador = new ControladorInventario(modelo, vista);

        // 4. Iniciar la aplicación 
        controlador.iniciar();
    }
}