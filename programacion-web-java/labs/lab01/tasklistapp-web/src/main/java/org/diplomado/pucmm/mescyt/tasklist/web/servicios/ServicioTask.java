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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.diplomado.pucmm.mescyt.taskapp.web.entidades.Task;
import org.diplomado.pucmm.mescyt.taskapp.web.utilidades.TaskAppException;

/**
 *
 * @author ecabrerar
 */
public class ServicioTask extends ServicioPersistenciaBase {

    public boolean guardarTask(Task task) {

        boolean estado;

        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement("insert into task (nombre,descripcion,prioridad)values(?,?,?)")) {
                stmt.setString(1, task.getNombre());
                stmt.setString(2, task.getDescripcion());
                stmt.setString(3, task.getPrioridad());

                estado = stmt.execute();

            }

        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
            estado = false;
        }

        return estado;

    }

    public boolean modificarTask(Task task) {

        boolean estado;

        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement("update task set nombre=?,descripcion=?,prioridad=?,finalizado=? where id=?")) {
                stmt.setString(1, task.getNombre());
                stmt.setString(2, task.getDescripcion());
                stmt.setString(3, task.getPrioridad());
                stmt.setBoolean(4, task.isFinalizado());
                stmt.setInt(5, task.getId());

                estado = stmt.execute();
            }

        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
            estado = false;
        }

        return estado;

    }

    public List<Task> consultarTaskTodas() {

        List<Task> lista = new ArrayList<>();

        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement("select * from task order by id desc")) {

                try (ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {

                        Task task = new Task();
                        task.setId(rs.getInt("id"));
                        task.setDescripcion(rs.getString("descripcion"));
                        task.setNombre(rs.getString("nombre"));
                        task.setPrioridad(rs.getString("prioridad"));
                        task.setFinalizado(rs.getBoolean("finalizado"));

                        lista.add(task);
                    }
                }
            }

        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public List<Task> consultarPorFinalizado(boolean isFinalizado) {

        List<Task> lista = new ArrayList<>();

        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement("select * from task t where t.finalizado = ? order by id desc")) {
                stmt.setBoolean(1, isFinalizado);

                try (ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {

                        Task task = new Task();
                        task.setId(rs.getInt("id"));
                        task.setDescripcion(rs.getString("descripcion"));
                        task.setNombre(rs.getString("nombre"));
                        task.setPrioridad(rs.getString("prioridad"));
                        task.setFinalizado(rs.getBoolean("finalizado"));

                        lista.add(task);
                    }
                }
            }

        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    public List<Task> consultarTaskAbierta() {

        List<Task> lista = new ArrayList<>();

        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement("select * from task t where t.finalizado = false order by id desc")) {
               
                try (ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {

                        Task task = new Task();
                        task.setId(rs.getInt("id"));
                        task.setDescripcion(rs.getString("descripcion"));
                        task.setNombre(rs.getString("nombre"));
                        task.setPrioridad(rs.getString("prioridad"));
                        task.setFinalizado(rs.getBoolean("finalizado"));

                        lista.add(task);
                    }
                }
            }

        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public Optional<Task> consultarTaskPorId(int id) throws TaskAppException {

        Optional<Task> opEntidad = Optional.empty();

        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement("select * from task where id=?")) {
                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery()) {

                    rs.next();

                    Task task = new Task();
                    task.setId(rs.getInt("id"));
                    task.setDescripcion(rs.getString("descripcion"));
                    task.setNombre(rs.getString("nombre"));
                    task.setPrioridad(rs.getString("prioridad"));
                    task.setFinalizado(rs.getBoolean("finalizado"));

                    opEntidad = Optional.of(task);
                }

            }
        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioPersistenciaBase.class.getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
            throw new TaskAppException(ex);
        }

        return opEntidad;

    }

    public boolean borrarTask(int id) {

        boolean estado;

        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement("delete from task where id=?")) {
                stmt.setInt(1, id);

                estado = stmt.execute();
            }
        } catch (SQLException | TaskAppException ex) {
            Logger.getLogger(ServicioTask.class.getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
            estado = false;
        }

        return estado;
    }
}
