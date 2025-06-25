package SistemaPedidosDigitales;

public class producto {
    private String codigo;
    private String nombre;
    private double precio;

    public producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " - S/ " + precio;
    }
}
