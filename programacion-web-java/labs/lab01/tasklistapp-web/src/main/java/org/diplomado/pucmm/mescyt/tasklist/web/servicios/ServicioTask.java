/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.tasklist.web.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.diplomado.pucmm.mescyt.taskapp.web.entidades.Task;
import org.diplomado.pucmm.mescyt.taskapp.web.utilidades.TaskAppException;

/**
 *
 * @author ecabrerar
 */
public class ServicioTask extends ServicioPersistenciaBase {

    public List<Task> consultarTodas() throws TaskAppException {
        
        
        Function<ResultSet,Task> function = (ResultSet rs) -> {
            Task task = new Task();
            
            try {

                task.setId(rs.getInt("id"));
                task.setDescripcion(rs.getString("descripcion"));
                task.setNombre(rs.getString("nombre"));
                task.setPrioridad(rs.getString("prioridad"));
                task.setFinalizado(rs.getBoolean("finalizado"));

            } catch (SQLException ex) {
                Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return task;

        };

      return  consultarTodas("select * from task order by id asc",function);

       
    }

    public Optional<Task> consultarTaskPorId(int id) {

        Optional<Task> opEntidad;

        try (ResultSet rs = consultarPorId("select * from task where id=?", id)) {

            rs.next();

            Task task = new Task();
            task.setId(rs.getInt("id"));
            task.setDescripcion(rs.getString("descripcion"));
            task.setNombre(rs.getString("nombre"));
            task.setPrioridad(rs.getString("prioridad"));
            task.setFinalizado(rs.getBoolean("finalizado"));

            opEntidad = Optional.of(task);

        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));

            opEntidad = Optional.empty();
        }

        return opEntidad;
    }

    public boolean borrarTask(int id) {

        boolean estado = true;

        try {
            estado = borrarRegistro("delete from task where id=?", id);
        } catch (TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estado;

    }
    
    
    public boolean guardarTask(Task task){
        
        boolean estado = true;
        
        try(Connection con = getConeccion()){
            
            try(PreparedStatement stmt = con.prepareStatement("")){
                stmt.setString(1, task.getNombre());
                stmt.setString(2, task.getDescripcion());
                stmt.setString(3, task.getPrioridad());
                
                estado = actualizarRegistro(stmt);
            } 
            
        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estado;
        
    }
    
    
    public boolean modificarTask(Task task){
        
        boolean estado = true;
        
        try(Connection con = getConeccion()){
            
            try(PreparedStatement stmt = con.prepareStatement("")){
                stmt.setString(1, task.getNombre());
                stmt.setString(2, task.getDescripcion());
                stmt.setString(3, task.getPrioridad());
                stmt.setBoolean(4, task.isFinalizado());
                stmt.setInt(5, task.getId());
                
                estado = actualizarRegistro(stmt);
            } 
            
        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estado;
        
    }
}
