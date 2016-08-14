/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.petcareapp.javaee.rest;

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