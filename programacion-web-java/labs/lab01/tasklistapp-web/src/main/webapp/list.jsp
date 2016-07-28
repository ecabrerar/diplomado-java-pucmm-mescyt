<%-- 
    Document   : list.jsp
    Created on : Jul 23, 2016, 5:22:33 PM
    Author     : ecabrerar
--%>

<%@page import="org.diplomado.pucmm.mescyt.taskapp.web.entidades.Task"%>
<%@page import="java.util.List"%>
<%@page import="org.diplomado.pucmm.mescyt.tasklist.web.servicios.ServicioTask"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultas Task</title>
    </head>
    <body>

        <table style="width: 100%">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Prioridad</th>
                
            </tr>
            <%
               ServicioTask servicioTask = new ServicioTask();
               List<Task> lista = servicioTask.consultarTaskTodas();
               
               for(Task t : lista){
             %>
             <tr> 
                 <td><%=t.getId()%></td>
                  <td><%=t.getDescripcion()%></td>
                  <td><%=t.getNombre()%></td>
                  <td><%=t.getPrioridad()%></td>
                  
             </tr>
             <%
               }
              %>

        </table>



    </body>
</html>
