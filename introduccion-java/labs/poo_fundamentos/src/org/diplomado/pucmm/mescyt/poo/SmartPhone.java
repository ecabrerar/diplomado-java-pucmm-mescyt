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
public class SmartPhone extends Telefono implements Conectividad, Plataforma{
    private boolean touchScreen;
    private boolean conectividadWifi;
    private String sistemaOperativo;

    public SmartPhone(String nombre, Marca marca, String modelo) {
        super(nombre, marca, modelo);
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    @Override
    public void setWifi(boolean wifi) {
        this.conectividadWifi = wifi;
    }

    @Override
    public boolean isWifi() {
       return this.conectividadWifi;
    }

    @Override
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String getSistemaOperativo() {
       return this.sistemaOperativo;
    }
}
