/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.petcareapp.javaee.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.entidades.Raza;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.servicios.ServicioRaza;

/**
 *
 * @author ecabrerar
 */
@Path("/raza")
public class ServicioRestRaza {
   
    @Inject
    ServicioRaza servicioRaza;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Raza> consultarRazas(){
        
        
        return servicioRaza.consultarTodas();
    }  
}
