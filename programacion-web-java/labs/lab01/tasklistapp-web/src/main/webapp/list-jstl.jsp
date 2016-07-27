<%-- 
    Document   : list.jsp
    Created on : Jul 23, 2016, 5:22:33 PM
    Author     : ecabrerar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="org.diplomado.pucmm.mescyt.taskapp.web.entidades.Task"%>

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
       
             <c:forEach items="${task_list}" var="task">
                 <tr> 
                 <td>${task.getId()}</td>
                  <td>${task.getDescripcion()}</td>
                  <td>${task.getNombre()}</td>
                  <td>${task.getPrioridad()}</td>
                  
             </tr>
                 
             </c:forEach>
             

        </table>



    </body>
</html>
