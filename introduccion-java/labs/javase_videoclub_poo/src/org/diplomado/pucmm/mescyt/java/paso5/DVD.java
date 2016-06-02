/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso5;

/**
 *
 * @author ecabrerar
 */
public class DVD {

    private final String titulo;
    private final TipoPelicula tipo;

    public DVD(String titulo, TipoPelicula tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoPelicula getTipo() {
        return tipo;
    }

    public double getImporte(int tiempo) {

        double importe = 0;
        
        switch (getTipo()) {
            case NORMAL:
                importe += 70;

                if (tiempo > 2) {
                    importe += (tiempo - 2) * 5;
                }

                break;
            case INFANTIL:

                importe += 60;

                if (tiempo > 3) {
                    importe += (tiempo - 3) * 5;
                }

                break;
            case NOVEDAD:
                importe += tiempo * 80;
                break;

            default:
                break;
        }
        return importe;
    }
    

}
