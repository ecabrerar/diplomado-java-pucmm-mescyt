<%-- 
  error page

  Reference: http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
--%>

<!-- error.jsp -->
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:taskapp-layout title="taskapp error" >
 
    <jsp:attribute  name="navigationBarActions">		
		<a title="Back" class="element" href="/tasks"> <span
			class="icon-arrow-left on-left"></span><span>retornar</span>
		</a>	
    </jsp:attribute>

    <jsp:attribute  name="mainBody"> 
      	<h1>
			<i class="icon-bug fg-darker smaller"></i>
			Ha ocurrido un error
		</h1>

        <p class="padding20 margin20"> ${message} Pulsar el boton de retornar para recargar.

       <!--
            This is for DEV sample only. DO NOT USE FOR PRODUCTION!
            
            Failed URL: ${url}
       <c:if test="${not empty exception}">
             Exception:  ${exception.message}
             <c:forEach items="${exception.stackTrace}" var="ste">    
                  ${ste} 
            </c:forEach>
       </c:if>
        -->
    </jsp:attribute>
    
</t:taskapp-layout>