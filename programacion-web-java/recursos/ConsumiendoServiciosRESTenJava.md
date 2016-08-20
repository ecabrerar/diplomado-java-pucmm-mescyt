**JAX-RS 2.0 (JSR 339)** no solo especifica el API para construir un servicio web REST sino que también mejora la API del lado del cliente para facilitar el proceso de escritura de un cliente para un servicio REST.

El API del cliente JAX-RS, que es una API basada en Java para la comunicación fluida con los servicios Web REST.  Este API estándar, también forma parte de Java EE 7 y está diseñado para que sea muy fácil de consumir un servicio Web expuesto a través del protocolo HTTP y permite a los desarrolladores implementar de forma concisa y eficiente soluciones del lado del cliente portátiles.

**Resumen de uso del cliente JAX-RS.**

Podemos crear un cliente rest y relacionarlo a una URL de destino específico, con parámetros específicos utilizando los siguientes pasos:

Obtener una referencia de cliente mediante la clase **ClientBuilder****_: Client client = ClientBuilder.newClient();_**

Especificar la URL destino del servicio REST utilizando el método **_target(): client.target("http://localhost:8080/myrestservice");_**

Manejar los parámetros de URL dinámica utilizando **path()** y **resolveTemplate()**: **_client.target(..).path("{id}").resolveTemplate(“id”, someId);_**

Utilice el método **request()  **para iniciar la construcción de la solicitud seguido por uno de los métodos, por ejemplo, **post(), get(): client.target(..).request().get();**

Cada pasos ofrece una variedad de posibles parámetros y opciones de configuración, voy a estar cubriendo algunos de ellos como las peticiones asíncronas, manejador de devolución de llamada y los filtros y clases de entidad posteriores.

En el siguiente ejemplo vamos a construir un cliente para un servicio REST de lo que hemos trabajado anteriormente.

La idea principal es explorar las diferentes opciones, por ejemplo, cómo manejar las peticiones de una manera síncrona o asíncrona, cómo añadir manejadores de devolución de llamada para una solicitud, cómo especificar los objetivos de invocación para construir las solicitudes para una ejecución posterior o cómo filtrar la comunicación cliente-servidor utilizando filtros solicitud del cliente y filtros de respuesta del cliente.

Si estamos trabajando en un proyecto Java EE 7 no tenemos que agregar dependencias adicionales.

En caso de estar trabajando en un proyecto que no sea Java EE 7 tenemos que agregar las siguientes dependencias.
```xml
<dependency>

     <groupId>org.glassfish.jersey.core</groupId>
     <artifactId>jersey-client</artifactId>
     <version>2.22.1</version>

</dependency>

<dependency>

       <groupId>org.glassfish.jersey.media</groupId>
       <artifactId>jersey-media-json-jackson</artifactId>
       <version>2.22.1</version>

</dependency>
```
Nota:

JAX-RS es el API para la creacion y consumo de servicios web y existen varias implementaciones de este API, entre ellas las dos mas famosas son Jersey https://jersey.java.net/documentation/latest/index.html y REST-Easy http://resteasy.jboss.org/. Nosotros usaremos Jersey en nuestro ejemplo.

El siguiente es un ejemplo sencillo.

```java
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
```

El ejemplo anterior devuelve la respuesta como un arreglo de datos en formato JSON, si queremos tratar esos datos, debemos agregar la siguiente dependencia.

```xml
<dependency>
    <groupId>org.glassfish</groupId>
    <artifactId>javax.json</artifactId>
    <version>1.0.4</version>
</dependency>
```
El ejemplo anterior modificado, para parsear el resultado usando JSON-P

```java

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

        //Consulta al servicio usando el metodo GET y la respuesta que devolvera es un String.
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

```

El ejemplo completo se encuentra en **programacion-web-java/labs/lab04**, con el nombre **servicios-rest-cliente**

Descargar el proyecto y abrir en netbeans.

Para correr el ejemplo, clic derecho encima del proyecto, luego la opción Run. Asegurarse que el proyecto petcareapp­javaee7 este corriendo en  glassfish, de lo contrario, el proyecto cliente no podrá conectarse a los servicios web. 

