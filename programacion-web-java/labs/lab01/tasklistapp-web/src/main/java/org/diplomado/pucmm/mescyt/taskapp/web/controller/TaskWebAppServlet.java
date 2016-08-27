package org.diplomado.pucmm.mescyt.taskapp.web.controller;

import java.io.IOException;
import java.io.UncheckedIOException;
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
@WebServlet(urlPatterns = {"/tasks/*"})
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
            case "":
                getTaskList(request, response);
                break;
            case "/registrar":
                getRegistrarTaskForm(request, response);
                break;
            default:
                getFormTaskEdicion(request, response);
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
            case "borrar":
                borrarTask(request, response);
                break;
            case "salvar":
                guardarTask(request, response);
                break;
            default:
                throw new ServletException("Peticion desconocida");
        }
    }

    /**
     * Renders the creation form.
     */
    private void getRegistrarTaskForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/task-form.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Obtener task list, filtrada por estado (todas, abierta y finalizada
     *
     */
    private void getTaskList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Task> taskList;
        String filter = request.getParameter("filter");
        
        switch (filter != null ? filter : "") {
            case "abierta":
                   taskList = servicioTask.consultarTaskAbierta();
                break;
            case "finalizada":
                taskList = servicioTask.consultarPorFinalizado("finalizada".equals(filter));
                break;
            case "todas":
            default:
                taskList = servicioTask.consultarTaskTodas();
                filter = "todas";
        }

        request.setAttribute("tasks", taskList);
        request.setAttribute("filter", filter);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/task-list.jsp")
                .forward(request, response);
    }

    /**
     * Obtener el registro a modificar y enviar al formulario de edicion
     */
    private void getFormTaskEdicion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = id(request);

        try {

            Task item = servicioTask.consultarTaskPorId(id).get();
            request.setAttribute("task", item);

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/task-form.jsp");

            dispatcher.forward(request, response);

        } catch (TaskAppException ex) {
            Logger.getLogger(TaskWebAppServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Registrar o modificar una tarea.
     */
    private void guardarTask(HttpServletRequest request, HttpServletResponse response) {

        Task item = new Task();
        item.setDescripcion(request.getParameter("descripcion"));
        item.setNombre(request.getParameter("nombre"));
        item.setPrioridad(request.getParameter("prioridad"));
        item.setFinalizado("on".equals(request.getParameter("finalizado")));

        if ("/registrar".equals(request.getPathInfo())) {
            servicioTask.guardarTask(item);
        } else {
            item.setId(id(request));

            servicioTask.modificarTask(item);
        }

        redirect(response, request.getContextPath()+"/tasks");

    }

    /**
     * Borrar una tarea
     */
    private void borrarTask(HttpServletRequest request, HttpServletResponse response) {
        int id = id(request);

        servicioTask.borrarTask(id);

        redirect(response, request.getContextPath()+"/tasks");

    }

    /**
     * Extraer id desde the Http request.
     */
    private int id(HttpServletRequest request) {
        int id = 0;
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.length() > 1) {
            String idString = pathInfo.substring(1);
            // This can throw NumberFormatException
            id = Integer.valueOf(idString);
        }
        return id;
    }

    /**
     * Metodo para redireccionar
     *
     * @param response
     * @param redirectLocation
     */
    private void redirect(HttpServletResponse response, String redirectLocation) {
        try {
            response.sendRedirect(redirectLocation);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
