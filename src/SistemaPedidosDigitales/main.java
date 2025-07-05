package SistemaPedidosDigitales;

import excepciones.ProductoNoEncontradoException;

public class main {
    public static void main(String[] args) {
        usuario usuario = new usuario("001", "Juanito", "cliente");

        gestorPedidos gestor = new gestorPedidos();

        //método sobrecargado
        gestor.agregarProducto("P001", "Audífonos", 59.90);
        gestor.agregarProducto("P002", "Teclado", 120.00);

        //try-catch
        try {
            double precio = gestor.calcularPrecioConDescuento(-20); // Error
            System.out.println("Precio con descuento: S/ " + precio);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // excepción 
        try {
            producto encontrado = gestor.buscarProductoPorCodigo("P002");
            System.out.println("Producto encontrado: " + encontrado);
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProductos registrados:");
        gestor.mostrarProductos();
        
        try {
            gestor.eliminarProductoPorCodigo("P001");
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        // Guardar en archivo
        gestor.guardarProductoEnArchivo();
        
    }
}
