package org.diplomado.pucmm.mescyt.taskapp.web.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.diplomado.pucmm.mescyt.tasklist.web.servicios.ServicioTask;

/**
 * 
 *
 * @author ecabrerar
 */
@WebServlet(urlPatterns = {"/index.html"})
public class HomeServlet extends HttpServlet {

    private ServicioTask servicioTask;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servicioTask = new ServicioTask();
    }
    
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
       
        request.setAttribute("tasks", servicioTask.consultarTaskTodas());
        
        getServletContext()
            .getRequestDispatcher("/WEB-INF/jsp/task-list.jsp")
            .forward(request, response);
    }    

}
