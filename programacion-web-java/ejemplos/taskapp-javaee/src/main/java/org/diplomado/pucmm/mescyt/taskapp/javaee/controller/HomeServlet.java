package org.diplomado.pucmm.mescyt.taskapp.javaee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * @author ecabrerar
 */
@WebServlet(urlPatterns = {"/index.html"})
public class HomeServlet extends HttpServlet {
    
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
       
         getServletContext()
            .getRequestDispatcher("/WEB-INF/jsp/index.jsp")
            .forward(request, response);
    }    

}
