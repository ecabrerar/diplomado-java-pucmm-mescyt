/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.poo;

import org.diplomado.pucmm.mescyt.poo.utilidades.ICalcularPrecio;
import org.diplomado.pucmm.mescyt.poo.utilidades.PrecioDB;

/**
 *
 * @author ecabrerar
 */
public class Telefono extends DispositivosMoviles implements ICalcularPrecio{
    private boolean enviarSms;
    private boolean recibirLlamadas;
    private boolean agendaContacto;

    public Telefono(String nombre, Marca marca, String modelo) {
        super(nombre, marca, modelo);
    }

    public boolean isEnviarSms() {
        return enviarSms;
    }

    public void setEnviarSms(boolean enviarSms) {
        this.enviarSms = enviarSms;
    }

    public boolean isRecibirLlamadas() {
        return recibirLlamadas;
    }

    public void setRecibirLlamadas(boolean recibirLlamadas) {
        this.recibirLlamadas = recibirLlamadas;
    }

    public boolean isAgendaContacto() {
        return agendaContacto;
    }

    public void setAgendaContacto(boolean agendaContacto) {
        this.agendaContacto = agendaContacto;
    }

    @Override
    public String toString() {
        return String.format("Nombre:%s,Marca:%s,Modelo:%s, Precio:%.2f", super.getNombre(),super.getMarca(),super.getModelo(),getPrecio());
    }  

    @Override
    public double getPrecio() {
       return PrecioDB.getPrecio(getMarca());
    }
    
}
