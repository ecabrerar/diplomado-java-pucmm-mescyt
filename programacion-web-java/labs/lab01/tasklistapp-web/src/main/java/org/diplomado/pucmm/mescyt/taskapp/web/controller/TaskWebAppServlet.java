package org.diplomado.pucmm.mescyt.taskapp.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.diplomado.pucmm.mescyt.taskapp.web.entidades.Task;
import org.diplomado.pucmm.mescyt.taskapp.web.utilidades.TaskAppException;
import org.diplomado.pucmm.mescyt.tasklist.web.servicios.ServicioTask;

/**
 *
 *
 * @author ecabrerar
 */
@WebServlet(urlPatterns = {"/tasks/*"}, asyncSupported = true)
public class TaskWebAppServlet extends HttpServlet {

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
        String pathInfo = request.getPathInfo();
        switch (pathInfo != null ? pathInfo : "") {
            case "": {
                try {
                    getTaskList(request, response);
                } catch (TaskAppException ex) {
                    Logger.getLogger(TaskWebAppServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "/create":
                getCreateTodoForm(request, response);
                break;
            default:
            // getEditTodoForm(request, response);
        }
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

        String action = request.getParameter("action");
        switch (action != null ? action : "") {
            case "delete":
                //deleteTodo(request, response);
                break;
            case "save":
                // saveTodo(request, response);
                break;
            default:
                throw new ServletException("Unknown action");
        }
    }

    /**
     * Renders the creation form.
     */
    private void getCreateTodoForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/task-form.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Get the task list, filtered by the completion status (all, open and
     * done).
     */
    private void getTaskList(HttpServletRequest request, HttpServletResponse response) throws TaskAppException, ServletException, IOException {

        List<Task> taskList = new ArrayList<>();
        String filter = request.getParameter("filter");
        switch (filter != null ? filter : "") {
            case "open":
            case "done":
                // taskList = todoService.findByCompleted("done".equals(filter));
                break;
            case "all":
            default:
                taskList = servicioTask.consultarTodas();
                filter = "all";
        }

        request.setAttribute("todos", taskList);
        request.setAttribute("filter", filter);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/task-list.jsp")
                .forward(request, response);
    }

}
