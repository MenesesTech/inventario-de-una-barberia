
package model;


public class proveedor {
    private String nombre;
    private String descripcion;
    private String address;
    private String telefono;
    private String correo;

    public proveedor() {
    }

    public proveedor(String nombre, String descripcion, String address, String telefono, String correo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.address = address;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
