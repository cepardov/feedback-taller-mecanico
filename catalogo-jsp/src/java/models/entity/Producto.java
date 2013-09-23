package models.entity;

public class Producto {

    protected int id;
    protected String nombre;
    protected int precio;
    protected int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("Id: ");
        buf.append(Integer.toString(getId()));
        buf.append(" Nombre: ");
        buf.append(getNombre());
        buf.append(" Precio: ");
        buf.append(getPrecio());
        buf.append(" Cantidad: ");
        buf.append(getCantidad());
        return buf.toString();
    }
}
