<%-- 
    Document   : list-pais
    Created on : Aug 6, 2016, 5:29:39 PM
    Author     : ecabrerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pantilla" tagdir="/WEB-INF/tags" %>

<pantilla:dashboard­layout title="Consulta Pais">
    <jsp:attribute name="mainBody">
        
          <h2 class="sub-header">Pais</h2>
        <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Descripcion</th>
                  <th></th>   
                  <th></th> 
                </tr>
              </thead>
              <tbody>
                  <c:forEach items="${listado_pais}" var="p">
               
                  <tr>
                      <td>${p.getId()}</td>
                       <td>${p.getDescripcion()}</td>
                       <td>
                        <a href="${pageContext.request.contextPath}/AdminServlet?cmd=show&id=${p.getId()}">Ver </a>
                        <a href="${pageContext.request.contextPath}/AdminServlet?cmd=edit&id=${p.getId()}">Editar</a>  

                           
                       </td>
                  </tr>
                  </c:forEach>
              </tbody>
            </table>

        
    </jsp:attribute>
    
    
</pantilla:dashboard­layout>
