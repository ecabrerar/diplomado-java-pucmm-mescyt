/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.servicios.rest.cliente;

import java.io.StringReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author ecabrerar
 */
public class PaisClienteRestOpBasicas {

    //Direccion del servicio web
    private final String URL = "http://localhost:8080/jsp-twitter-bootstrap/rest/paises";

    public void ejecutar() {
        System.out.println("===Consultar Todas===");

        consultarTodas();

        System.out.println("=== Async Consultar Todas===");

        asyncConsultarTodas();

        System.out.println("=== invocationCallback Consultar Todas===");
        invocationCallbackConsultarTodas();

        System.out.println("===Consultar Por Id===");

        consultarPorId();
    }

    private WebTarget inicializar() {
        Client cliente = ClientBuilder.newClient(); //Creando un cliente rest
        cliente.register(ClientResponseLoggingFilter.class)
                .register(RequestFilterBasico.class); //Registrando filtro
        WebTarget target = cliente.target(URL); //Especificar la direccion del servicio

        return target;
    }

    
        public void consultarTodas() {
        WebTarget target = inicializar();

        // Consulta al servicio usando el metodo GET y la respuesta que devolvera es un String.
        String resultado = target.request().get(String.class);

        //Usando el API JSON-P (JSR 353) para parsear los datos en formato JSON
        try (JsonReader jsonReader = Json.createReader(new StringReader(resultado))) {
            JsonArray array = jsonReader.readArray();

            for (JsonObject data : array.getValuesAs(JsonObject.class)) {
                System.out.print(data.getInt("id"));
                System.out.print(": ");
                System.out.println(data.getString("descripcion"));
                System.out.println("-----------");
            }

        }
    }
    
    public void asyncConsultarTodas() {
        WebTarget target = inicializar();

        // Consulta al servicio usando el metodo GET y la respuesta que devolvera es un String.
      Future<String>  resultado = target
                                    .request()
                                    .async()
                                    .get(String.class);

        //Usando el API JSON-P (JSR 353) para parsear los datos en formato JSON
        try (JsonReader jsonReader = Json.createReader(new StringReader(resultado.get()))) {
            JsonArray array = jsonReader.readArray();

            for (JsonObject data : array.getValuesAs(JsonObject.class)) {
                System.out.print(data.getInt("id"));
                System.out.print(": ");
                System.out.println(data.getString("descripcion"));
                System.out.println("-----------");
            }

        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PaisClienteRestOpBasicas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void invocationCallbackConsultarTodas() {
        try {
            WebTarget target = inicializar();
            
            // Consulta al servicio usando el metodo GET y la respuesta que devolvera es un String.
            target.request()
                    .async()
                    .get(new InvocationCallback<String>() {
                        
                        @Override
                        public void completed(String resultado) {
                            //Usando el API JSON-P (JSR 353) para parsear los datos en formato JSON
                            try (JsonReader jsonReader = Json.createReader(new StringReader(resultado))) {
                                JsonArray array = jsonReader.readArray();
                                
                                for (JsonObject data : array.getValuesAs(JsonObject.class)) {
                                    System.out.print(data.getInt("id"));
                                    System.out.print(": ");
                                    System.out.println(data.getString("descripcion"));
                                    System.out.println("-----------");
                                }
                                
                            }
                        }
                        
                        @Override
                        public void failed(Throwable thrwbl) {
                            System.out.println("Hubo un error"+thrwbl.getMessage());
                        }
                    }).get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PaisClienteRestOpBasicas.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    

    public void consultarPorId() {
        WebTarget target = inicializar();

        // Consulta al servicio usando el metodo GET y la respuesta que devolvera es un String.
        String resultado = target
                .path("/{id}")
                .resolveTemplate("id", 5)
                .request()
                .get(String.class);

        //Usando el API JSON-P (JSR 353) para parsear los datos en formato JSON
        try (JsonReader jsonReader = Json.createReader(new StringReader(resultado))) {
            JsonObject object = jsonReader.readObject();
            System.out.print(object.getInt("id"));
            System.out.print(": ");
            System.out.println(object.getString("descripcion"));
            System.out.println("-----------");

        }
    }
    
    
    public void borrarPorId(){
        WebTarget target = inicializar();
        
        // Consulta al servicio usando el metodo GET y la respuesta que devolvera es un String.
        Response resultado = target
                .path("/{id}")
                .resolveTemplate("id", 5)
                .request()
                .delete();
        
        System.out.println(resultado);
    }

    public static void main(String[] args) {
        PaisClienteRestOpBasicas cliente = new PaisClienteRestOpBasicas();
        cliente.ejecutar();
    }
}
