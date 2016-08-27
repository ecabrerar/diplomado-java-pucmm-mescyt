<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:taskapp-layout title="tasklist items" 
                   pageScript="${pageContext.request.contextPath}/static/js/task-list.js">
 
    <jsp:attribute  name="navigationBarActions">
        <a title="crear nueva tarea" class="element" href="${pageContext.request.contextPath}/tasks/registrar"> 
            <span class="icon-plus-2 on-left"></span><span>nueva tarea</span>
        </a>
    </jsp:attribute>

    <jsp:attribute  name="mainBody"> 
       <div id="controlSection" class="grid pos-rel">
         <h1> 
            <i class="icon-clipboard-2 smaller"></i> task<small class="on-right">list</small>
         </h1>

         <div class="button-set place-bottom-right" data-role="button-group" id="filterButtons">
            <span class="place-left on-left-more icon-arrow-right-3" style="margin-top: 5px"></span>
             <button id="todas"  ${filter == 'todas' ?  'class="active"' : ''} 
                title="ver todas"> todas </button>
            <button id="abierta" ${filter == 'abierta' ? 'class="active"' : ''} 
                title="ver solamente tasks abiertas"> abierta </button>
            <button id="finalizada" ${filter == 'finalizada' ? 'class="active"' : ''}
                title="ver solamente tasks finalizadas" > finalizada </button>           
         </div>
       </div>
       <table class="table hovered">
          <thead>
             <tr>
                <th class="text-left span1" style="border-bottom: 1px solid #111;">Terminado</th>
                <th class="text-left span8" style="border-bottom: 1px solid #111;">Nombre</th>
                <th class="text-left span3" style="border-bottom: 1px solid #111;">Prioridad</th>
             </tr>
          </thead>
          <tbody>
             <c:forEach items="${tasks}" var="item">  
                <tr>
                     <td>
                         <i class="icon-checkbox${item.finalizado > 0 ? ' ' : '-unchecked'} fg-grayLight"></i>
                      </td>
                     <td>
                         <a href="${pageContext.request.contextPath}/tasks/${item.id}"> <c:out value="${item.nombre}"/> </a>
                     </td>
                     <td>${item.prioridad}</td>
                </tr>
             </c:forEach>  
         </tbody>
        </table>
    </jsp:attribute>
    
</t:taskapp-layout>