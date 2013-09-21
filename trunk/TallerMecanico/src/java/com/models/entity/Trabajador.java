/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models.entity;

/**
 *
 * @author cepardov
 */
public class Trabajador {
    protected String rut;
    protected String nombre;
    protected String paterno;
    protected String materno;
    protected int telefono;
    protected int cargo;
    protected String clave;

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getCargo() {
        return cargo;
    }

    public String getClave() {
        return clave;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("rut: ");
        buf.append(this.getRut());
        buf.append(" Nombre: ");
        buf.append(this.getNombre());
        buf.append(" Paterno: ");
        buf.append(this.getPaterno());
        buf.append(" Materno: ");
        buf.append(this.getMaterno());
        buf.append(" Telefono: ");
        buf.append(Integer.toString(this.getTelefono()));
        buf.append(" Cargo: ");
        buf.append(Integer.toString(this.getCargo()));
        buf.append(" Clave: ");
        buf.append(this.getClave());
        return buf.toString();
    }
}