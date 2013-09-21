/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entity;

/**
 *
 * @author Luis
 */
public class Cliente {
    protected String rut;
    protected String nombre;
    protected String paterno;
    protected String materno;
    protected int telefono;
    protected String email;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
      public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("rut: ");
        buf.append(getRut());
        buf.append(" Nombre: ");
        buf.append(getNombre());
        buf.append(" Paterno: ");
        buf.append(getPaterno());
        buf.append(" Materno: ");
        buf.append(getMaterno());
        buf.append(" Telefono: ");
        buf.append(Integer.toString(getTelefono()));
        buf.append(" Email");
        buf.append(getEmail());
        return buf.toString();
    }
}
