/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.diplomado.pucmm.mescyt.java.encapsulados.Usuario;

/**
 *
 * @author ecabrerar
 */
public class ServicioUsuario {

    private static final ServicioUsuario INSTANCIA = new ServicioUsuario();

    private static ServicioUsuario INSTANCIA_UNICA = null;

    private ServicioUsuario() {
    }

    public static ServicioUsuario getInstancia() {
        return INSTANCIA;
    }

    public static ServicioUsuario getInstanciaUnica() {

        if (INSTANCIA_UNICA == null) {
            INSTANCIA_UNICA = new ServicioUsuario();
        }
        return INSTANCIA_UNICA;
    }

    public void salvar(Usuario usuario) {

        String sqlInsert = "INSERT INTO usuario (nombre,apellido,usuario, clave) VALUES (?,?,?,?)";

        try (Connection con = ConeccionDB.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sqlInsert)) {
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getApellido());
                stmt.setString(3, usuario.getUsuario());
                stmt.setString(4, usuario.getClave());

                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, ex.getMessage());
        }

    }

    public void modificar(Usuario usuario) {
        String sqlUpdate = "UPDATE usuario SET nombre=?,apellido=?,usuario=?,clave=? WHERE codigo=?";

        try (Connection con = ConeccionDB.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sqlUpdate)) {
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getApellido());
                stmt.setString(3, usuario.getUsuario());
                stmt.setString(4, usuario.getClave());
                stmt.setInt(5, usuario.getCodigo());

                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }

    public List<Usuario> consultarTodos() {

        String sqlConsulta = "SELECT * FROM usuario ORDER BY codigo asc";

        List<Usuario> lista = new ArrayList<>();

        try (Connection con = ConeccionDB.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sqlConsulta)) {
                try (ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {

                        Usuario usuario = new Usuario();
                        usuario.setCodigo(rs.getInt(1));
                        usuario.setNombre(rs.getString(2));
                        usuario.setApellido(rs.getString("apellido"));
                        usuario.setUsuario(rs.getString("usuario"));
                        usuario.setClave(rs.getString(5));

                        lista.add(usuario);

                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public Usuario consultarPorId(int id) {

        String sqlConsulta = "SELECT * FROM usuario where id=?";

        Usuario usuario = null;

        try (Connection con = ConeccionDB.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sqlConsulta)) {
                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery()) {

                    if (rs.next()) {

                        usuario = new Usuario();
                        usuario.setCodigo(rs.getInt(1));
                        usuario.setNombre(rs.getString(2));
                        usuario.setApellido(rs.getString("apellido"));
                        usuario.setUsuario(rs.getString("usuario"));
                        usuario.setClave(rs.getString(5));

                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

}
