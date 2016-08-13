/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.petcareapp.javaee.controller;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.entidades.Pais;
import org.diplomado.pucmm.mescyt.java.petcareapp.javaee.servicios.ServicioPais;

/**
 *
 * @author ecabrerar
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    @Inject
    ServicioPais pais;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        String cmd = request.getParameter("cmd");

        if ("show".equals(cmd)) {

            if (!request.getParameter("id").isEmpty()) {

                Pais paisN = pais.consultarPorId(Integer.parseInt(request.getParameter("id")));

                servletContext.setAttribute("pais", paisN);
                servletContext.getRequestDispatcher("/form-pais.jsp")
                        .forward(request, response);
            }

        } else if ("edit".equals(cmd)) {

        }

        servletContext.setAttribute("listado_pais", pais.consultarTodas());
        servletContext.getRequestDispatcher("/list-pais.jsp")
                .forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!request.getParameter("btnSubmit").isEmpty()) {

            String id = request.getParameter("id");
            String descripcion = request.getParameter("descripcion");

            if (!id.isEmpty() && !descripcion.isEmpty()) {

                Pais p = new Pais(Integer.parseInt(id), descripcion);

                pais.modificar(p);

            }
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
