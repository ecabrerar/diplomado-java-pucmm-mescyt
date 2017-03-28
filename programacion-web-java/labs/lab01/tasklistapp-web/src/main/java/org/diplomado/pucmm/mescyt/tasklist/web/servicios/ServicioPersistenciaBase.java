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

}
