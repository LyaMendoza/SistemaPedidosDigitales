package SistemaPedidosDigitales;

import excepciones.ProductoNoEncontradoException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class gestorPedidos {
    private ArrayList<producto> listaProductos;
    private HashMap<String, producto> mapaProductos;

    public gestorPedidos() {
        listaProductos = new ArrayList<>();
        mapaProductos = new HashMap<>();
    }

    // Método original///
    public void agregarProducto(producto p) {
        listaProductos.add(p);
        mapaProductos.put(p.getCodigo(), p);
    }

    // Método sobrecargado///
    public void agregarProducto(String codigo, String nombre, double precio) {
    	producto nuevoProducto = new producto(codigo, nombre, precio);
        listaProductos.add(nuevoProducto);
        mapaProductos.put(codigo, nuevoProducto);
    }

    public void mostrarProductos() {
        for (producto p : listaProductos) {
            System.out.println(p);
        }
    }

    //HashMap///
    public producto obtenerProductoPorCodigo(String codigo) {
        return mapaProductos.get(codigo);
    }

    //excepción ////
    public producto buscarProductoPorCodigo(String codigo) throws ProductoNoEncontradoException {
        for (producto p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("Producto con código " + codigo + " no encontrado.");
    }

    // validación-errores///////
    public double calcularPrecioConDescuento(double descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0% y 100%");
        }
        double precioBase = 100.0; //ejemplo
        return precioBase - (precioBase * descuento / 100);
    }
    //Eliminar producto
    public void eliminarProductoPorCodigo(String codigo) throws ProductoNoEncontradoException {
    	producto eliminado= mapaProductos.remove(codigo);
    	if(eliminado== null) {
    		throw new ProductoNoEncontradoException("No se puede eliminar: Producto con código"+codigo+" no existe" );
    	}
    	listaProductos.removeIf(p ->p.getCodigo().equals(codigo));
    	  System.out.println("Producto con código"+codigo+" eliminado correctamente ");
    }
    
    //Guardar Producto txt
    public void guardarProductoEnArchivo() {
        try (FileWriter writer = new FileWriter("productos.txt")) {
        	for(producto p : listaProductos) {
        		writer.write(p.getCodigo()+","+p.getNombre()+","+p.getPrecio()+"\n");
        		       		
        	}
        	 System.out.println("Archivo productos.txt generado correctamente.");        	            
        } catch (IOException e) {
            System.out.println("Error al generar archivo:"+ e.getMessage()); 
        }
    }
}
