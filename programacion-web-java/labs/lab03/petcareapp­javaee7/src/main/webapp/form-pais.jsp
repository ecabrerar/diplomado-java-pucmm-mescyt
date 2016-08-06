<%-- 
    Document   : form-pais
    Created on : Aug 6, 2016, 5:49:15 PM
    Author     : ecabrerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pantilla" tagdir="/WEB-INF/tags" %>

<pantilla:dashboard title="Ver Pais">
    <jsp:attribute name="mainBody">
        
        <form method="post" action="${pageContext.request.contextPath}/AdminServlet"> 
            <input type="hidden" name="id" value="${pais.getId()}"/>
        <label for="inputEmail">Pais</label>   
        <input type="text"  name="descripcion" value="${pais.getDescripcion()}"/>
        <input type="submit" value="Aceptar" name="btnSubmit">
      </form>   
    
        
    </jsp:attribute>
 </pantilla:dashboard>