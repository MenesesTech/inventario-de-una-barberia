
package model;

public class producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private String estado;
    private String categoria;
    private int cantidad;
    private double pventa;

    public producto() {
    }

    public producto(String codigo, String nombre, String descripcion, String estado, String categoria, int cantidad, double pventa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.pventa = pventa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPventa() {
        return pventa;
    }

    public void setPventa(double pventa) {
        this.pventa = pventa;
    }
    
    
}
