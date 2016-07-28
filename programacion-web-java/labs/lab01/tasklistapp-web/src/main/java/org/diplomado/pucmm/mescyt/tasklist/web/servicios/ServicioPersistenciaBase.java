/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.tasklist.web.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.diplomado.pucmm.mescyt.taskapp.web.utilidades.TaskAppException;

/**
 *
 * @author ecabrerar
 */
public class ServicioPersistenciaBase {

    protected Connection getConeccion() throws TaskAppException {

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/TaskApp");

            Connection con = ds.getConnection();

            if (con == null) {
                throw new TaskAppException("No pudo establecer conexion con la base de datos");
            }

            return con;
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(ServicioPersistenciaBase.class.getName()).log(Level.SEVERE, null, ex);
            throw new TaskAppException(ex);
        }
    }

//    protected <T> List<T> consultarTodas(String sql,Function<ResultSet,T> function) throws TaskAppException {
//
//        final List<T> list = new ArrayList<>();
//          
//        try (Connection con = getConeccion()) {
//            try (PreparedStatement stmt = con.prepareStatement(sql)) {
//
//                try (ResultSet rs = stmt.executeQuery()) {
//
//                    while (rs.next()) {
//
//                        list.add(function.apply(rs));
//                    }
//                }
//            }
//
//        } catch (SQLException | TaskAppException ex) {
//            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
//            throw new TaskAppException(ex);
//        }
//        
//        return list;
//    }
//
//    protected <T> Optional<T> consultarPorId(String sql, Integer idEntidad,Function<ResultSet,T> function) throws TaskAppException {
//
//        Optional<T> opEntidad = Optional.empty();        
//        
//        try (Connection con = getConeccion()) {
//
//            try (PreparedStatement stmt = con.prepareStatement(sql)) {
//                stmt.setInt(1, idEntidad);
//
//                try(ResultSet rs = stmt.executeQuery()){
//                    
//                   opEntidad = Optional.of(function.apply(rs));
//                }
//
//            }
//        } catch (SQLException | TaskAppException ex) {
//            Logger.getLogger(ServicioPersistenciaBase.class.getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
//            throw new TaskAppException(ex);
//        }
//        
//        return opEntidad;
//
//    }
//    
//    
//    protected boolean borrarRegistro(String sql, Integer idEntidad) throws TaskAppException{
//        
//        try (Connection con = getConeccion()) {
//
//            try (PreparedStatement stmt = con.prepareStatement(sql)) {
//                  stmt.setInt(1, idEntidad);
//
//                return stmt.execute();
//
//            }
//        } catch (SQLException | TaskAppException ex) {
//            Logger.getLogger(ServicioPersistenciaBase.class.getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
//            throw new TaskAppException(ex);
//        }
//    }
//    
//     protected boolean actualizarRegistro(PreparedStatement stmt) throws TaskAppException{
//        
//      try{
//              return stmt.execute();
//            
//      } catch (SQLException ex) {
//            Logger.getLogger(ServicioPersistenciaBase.class.getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
//            throw new TaskAppException(ex);
//        }
//    }    
//     
//     
//     public <T> List<T> consultarTodasN(String sql, Function<ResultSet,T> transformar){
//         
//         List<T> list = new ArrayList<>();
//         
//         try(Connection con = getConeccion()){
//             
//             try(PreparedStatement stmt = con.prepareStatement(sql)){
//                 
//                 try(ResultSet rs = stmt.executeQuery()){
//                     while(rs.next()){
//                         list.add(transformar.apply(rs));
//                     }
//                 }
//                 
//             }
//             
//         } catch (SQLException | TaskAppException ex) {
//            Logger.getLogger(ServicioPersistenciaBase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//         return list;
//         
//     }
//     

}
