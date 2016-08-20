/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.servicios.rest.cliente;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author ecabrerar
 */
public class PaisClienteRest {

    public static void main(String[] args) {
        //Direccion del servicio web
        String URL = "http://localhost:8080/jsp-twitter-bootstrap/rest/paises";

        Client cliente = ClientBuilder.newClient(); //Creando un cliente rest
        WebTarget target = cliente.target(URL); //Especificar la direccion del servicio

        // Consulta al servicio usando el metodo GET y la respuesta que devolvera es un String.
        String resultado = target.request().get(String.class);

         System.out.println(resultado);
        
    }
}
