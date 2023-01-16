package hugo.monton.blanco.e09_listadelacompra.modelos;

public class Producto {
    // ATRIBUTOS
    private String nombre;
    private int cantidad;
    private float precio;

    // CONSTRUCTORES
    public Producto() {
    }
    public Producto(String nombre, int cantidad, float precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // MÉTODOS GENÉRICOS O PROPIOS
    @Override
    public String toString() {
        return "Producto {" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
