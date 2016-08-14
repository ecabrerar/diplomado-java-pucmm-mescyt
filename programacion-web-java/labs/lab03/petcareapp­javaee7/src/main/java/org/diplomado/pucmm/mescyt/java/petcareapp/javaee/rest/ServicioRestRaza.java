/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.petcareapp.javaee.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.entidades.Raza;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.servicios.ServicioRaza;

/**
 *
 * @author ecabrerar
 */
@Path("/razas")
public class ServicioRestRaza {
  @Inject
  ServicioRaza servicioRaza;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Raza> consultarRazas(){        
        return servicioRaza.consultarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Raza consultaPorId(@PathParam("id") int id){        
        return servicioRaza.consultarPorId(id);
    }
}
