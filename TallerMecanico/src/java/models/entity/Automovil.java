
package models.entity;

public class Automovil {
    protected String patente;
    protected String rutcliente;
    protected String color;
    protected int marca;
    protected int modelo;
    protected int año;
    protected int cilindrada;

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getRutcliente() {
        return rutcliente;
    }

    public void setRutcliente(String rutcliente) {
        this.rutcliente = rutcliente;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    
}
