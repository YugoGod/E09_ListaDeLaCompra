package hugo.monton.blanco.e09_listadelacompra.modelos;

public class Usuario {

    // ATRIBUTOS
    private String nombre;
    private String nTelefono;

    // CONSTRUCTORES
    public Usuario() {
    }
    public Usuario(String nombre, String nTelefono) {
        this.nombre = nombre;
        this.nTelefono = nTelefono;
    }

    // GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnTelefono() {
        return nTelefono;
    }
    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    // MÉTODOS GENÉRICOS O PROPIOS
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", nTelefono='" + nTelefono + '\'' +
                '}';
    }
}
