/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.taskapp.javaee.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.diplomado.pucmm.mescyt.taskapp.javaee.entidades.Task;
import org.diplomado.pucmm.mescyt.taskapp.javaee.servicios.ServicioTask;

/**
 *
 * @author ecabrerar
 * @date Aug 26, 2016
 */
@Path("/tasks")
public class ServicioRestTask {

    @Inject
    ServicioTask servicioTask;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Task> consultarTodas() {
        return servicioTask.consultarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task consultarTaskPorId(@PathParam("id") int id) {
        return servicioTask.consultarTaskPorId(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Task guardarTask(Task task){
        return servicioTask.guardarTask(task);
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes({MediaType.APPLICATION_JSON})
    public Task modificarTask(Task task){
       return servicioTask.modificarTask(task);
    }
    
    @DELETE
    @Path("{id}")
     public void borrarTask(@PathParam("id") int id){
        servicioTask.borrarTask(id);              
    }   
}
