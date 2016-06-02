/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.diseno_inicial;

/**
 *
 * @author ecabrerar
 */
public class DVD {

    private final String titulo;
    private final int tipo;

    public DVD(String titulo, int tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTipo() {
        return tipo;
    }

}
