package SistemaPedidosDigitales;

public class usuario {
    private String dni;
    private String nombre;
    private String rol;

    public usuario(String dni, String nombre, String rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }
}
