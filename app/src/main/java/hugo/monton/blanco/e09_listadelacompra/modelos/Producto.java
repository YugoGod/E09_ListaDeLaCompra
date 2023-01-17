package hugo.monton.blanco.e09_listadelacompra.modelos;

import java.text.NumberFormat;

public class Producto {
    // ATRIBUTOS
    private String nombre;
    private int cantidad;
    private float precio;

    private static final NumberFormat nf; // Variable de clase, que solo se instancia una vez(static), en cierto modo, y como no va a cambiar, la hacemos final.
    private static final NumberFormat nfNumeros;

    // Este constructor es un metod que se utiliza cuando quiero inicializar variables estáticas de clase. Inicializador de variables estáticas para quee cuando Java compile la aplicación, sin necesidad de que lo llame, se genera solo.
    static {
        nf = NumberFormat.getCurrencyInstance();
        nfNumeros = NumberFormat.getNumberInstance();
    }
    // Función que utilizaremos para cuando queramos el valor con formato moneda.
    public String getPrecioMoneda() {
        return nf.format(this.precio);
    }

    public String getCantidadTexto() {
        return nfNumeros.format(this.cantidad);
    }

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
