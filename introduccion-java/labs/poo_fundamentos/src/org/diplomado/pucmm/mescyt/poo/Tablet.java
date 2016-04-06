/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.poo;

/**
 *
 * @author ecabrerar
 */
public class Tablet extends DispositivosMoviles implements  Plataforma, Conectividad{
    private boolean multiTactil;
    private boolean conectividadWifi;
    private String sistemaOperativo;

    public Tablet(String nombre, Marca marca, String modelo) {
        super(nombre, marca, modelo);
    }

    public boolean isMultiTactil() {
        return multiTactil;
    }

    public void setMultiTactil(boolean multiTactil) {
        this.multiTactil = multiTactil;
    }

    @Override
    public void setSistemaOperativo(String sistemaOperativo) {
       this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String getSistemaOperativo() {
        return this.sistemaOperativo;
    }

    @Override
    public void setWifi(boolean wifi) {
        this.conectividadWifi=wifi;
    }

    @Override
    public boolean isWifi() {
       return this.conectividadWifi;
    }
    
     @Override
    public String toString() {
        return String.format("Nombre:%s,Marca:%s,Modelo:%s. \nSistema Operativo: %s\n %s %s", super.getNombre(),super.getMarca(),super.getModelo(),getSistemaOperativo(), conectividadWifi?"WIFI":"No WIFI", multiTactil?"Multitactil":"No Multitactil");
    }  
}
