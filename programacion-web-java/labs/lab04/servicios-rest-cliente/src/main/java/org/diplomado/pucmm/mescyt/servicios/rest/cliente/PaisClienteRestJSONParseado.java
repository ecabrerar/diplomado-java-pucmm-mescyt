/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.servicios.rest.cliente;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author ecabrerar
 */
public class PaisClienteRestJSONParseado {
      public static void main(String[] args) {
        //Direccion del servicio web
        String URL = "http://localhost:8080/jsp-twitter-bootstrap/rest/paises";

        Client cliente = ClientBuilder.newClient(); //Creando un cliente rest
        WebTarget target = cliente.target(URL); //Especificar la direccion del servicio

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
}
