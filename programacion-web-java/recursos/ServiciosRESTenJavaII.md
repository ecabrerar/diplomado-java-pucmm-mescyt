**Servicios REST en Java Integración con Base de Datos**

En el ejemplo anterior trabajamos con una lista estática de valores y ahora vamos a realizar lo mismo usando JPA y MySQL.

En el proyecto **petcareapp­javaee7** habiamos creado una clase llamado **ServicioPais**, que contiene los métodos **List<Pais> consultarTodas(), Pais modificar(@NotNull Pais pais), Pais consultarPorId(@NotNull int idPais) y void borrarPorId(@NotNull int idPais)**. 

Vamos a utilizar el mismo servicio **ServicioRestPais** y vamos a agregar los métodos que nos permite consultar todos los países, otro que nos permita filtrar por id, uno de modificar y un último de borrar.

```java
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pais> consultarPaises(){ 
       return servicioPais.consultarTodas();
    }
```
**@GET** indica que estaremos usando el método GET del protocolo http para realizar la consulta

    ```java
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Pais consultarPaisPorId(@PathParam("id") int id){
        return servicioPais.consultarPorId(id);
    }

    ```
**@GET** indica que estaremos usando el método GET del protocolo http para realizar la consulta

```java
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void modificarPais(@PathParam("id") Integer id, Pais pais) {
       servicioPais.modificar(pais); 
    }
```
**@PUT** indica que estaremos usando el método PUT del protocolo http para realizar una actualización.

```java
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        servicioPais.borrarPorId(id);
    } 

```
**@DELETE** indica que estaremos usando el método DELETE del protocolo http para borrar un registro.

**@PathParam("id") int id** Indica el nombre y el tipo de dato del parámetro.
**@Produces({MediaType.APPLICATION_JSON})** Indica que el resultado sera en formato JSON.


Poniendo todo junto
```java
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.entidades.Pais;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.servicios.ServicioPais;

/**
 *
 * @author ecabrerar
 */
@Path("/paises")
public class ServicioRestPais {
    
    @Inject ServicioPais servicioPais; 
      
    @GET
    @Path("/static")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pais> consultarTodas(){ 
       return getPaises();
    }
    
    @GET
    @Path("/static/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Pais consultarPorId(@PathParam("id") int id){
        List<Pais> lista = getPaises();
        
        if(id < lista.size()){
            return lista.get(id);
        }else {
            return null;
        }        
    }
    
    private List<Pais> getPaises(){
        List<Pais> lista = new ArrayList<>();
        lista.add(new Pais(1, "Republica Dominicana"));
        lista.add(new Pais(2, "Venezuela"));
        lista.add(new Pais(3, "Nicaragua"));
        lista.add(new Pais(4, "Uruguay"));
        lista.add(new Pais(5, "Haiti"));
        
        return lista;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pais> consultarPaises(){ 
       return servicioPais.consultarTodas();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Pais consultarPaisPorId(@PathParam("id") int id){
        return servicioPais.consultarPorId(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void modificarPais(@PathParam("id") Integer id, Pais pais) {
       servicioPais.modificar(pais); 
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        servicioPais.borrarPorId(id);
    } 
}
```

Como estamos usando CDI no necesitamos instanciar el servicio, solo tenemos que usar la anotacion
**@Inject** y servidor de aplicacione se encargará de lo demás.


Para correr el ejemplo, clic derecho encima del proyecto, luego la opción Run. Asegurarse que el servidor glassfish esté encendido a la hora de darle a correr. Url para acceder al ejemplo 

[http://localhost:8080/jsp-twitter-bootstrap/](http://localhost:8080/jsp-twitter-bootstrap/)

Para acceder a nuestro servicio

[http://localhost:8080/jsp-twitter-bootstrap/rest/paises](http://localhost:8080/jsp-twitter-bootstrap/rest/paises)      Consultar todos

[http://localhost:8080/jsp-twitter-bootstrap/rest/paises/2](http://localhost:8080/jsp-twitter-bootstrap/rest/paises/2)   Consultar el pais con id 2.

Para actualizar tenemos que hacerlo desde un cliente rest.


