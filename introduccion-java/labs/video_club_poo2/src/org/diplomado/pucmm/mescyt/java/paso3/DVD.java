/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso3;

/**
 *
 * @author ecabrerar
 */
public class DVD {

    private final String titulo;
    private Tarifa tarifa;

    public DVD(String titulo, TipoPelicula tipo) {
        this.titulo = titulo;
        setTipo(tipo);
    }
    
    private void setTipo(TipoPelicula tipo){
        
        switch(tipo){
            case NORMAL:
                tarifa = new TarifaNormal();
                break;
            case INFANTIL:
                tarifa= new TarifaInfantil();
                break;
            case NOVEDAD:
                tarifa = new TarifaNovedad();
                break;
            default:
                break;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoPelicula getTipo() {
        return tarifa.getTipo();
    }

    public int getPuntos(int tiempo) {
       return tarifa.getPuntos(tiempo);
    }

    public double getImporte(int tiempo) {
       return tarifa.getImporte(tiempo);
    }

}
