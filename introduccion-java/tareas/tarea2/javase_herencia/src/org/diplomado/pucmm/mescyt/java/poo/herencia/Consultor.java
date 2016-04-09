package org.diplomado.pucmm.mescyt.java.poo.herencia;

import java.util.Date;

public class Consultor extends Persona  {
    private double horaTrabajadas;
    private double precioHoras;
    
    public Consultor(String string, String string1, String string2, Date date) {
        super(string, string1, string2, date);
    }
    


    @Override
    public double calcularSueldo() {
        return 0;
    }

    public double getHoraTrabajadas() {
        return horaTrabajadas;
    }

    public void setHoraTrabajadas(double horaTrabajadas) {
        this.horaTrabajadas = horaTrabajadas;
    }

    public double getPrecioHoras() {
        return precioHoras;
    }

    public void setPrecioHoras(double precioHoras) {
        this.precioHoras = precioHoras;
    }
}
