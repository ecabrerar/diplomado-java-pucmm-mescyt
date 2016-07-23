<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:taskapp-layout title="tasklist items" 
                   pageScript="${pageContext.request.contextPath}/static/js/task-list.js">
 
    <jsp:attribute  name="navigationBarActions">
        <a title="crear nueva tarea" class="element" href="/tasks/create"> 
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
             <button id="all"  ${filter == 'all' ?  'class="active"' : ''} 
                title="view all todos"> all </button>
            <button id="open" ${filter == 'open' ? 'class="active"' : ''} 
                title="view only open todos"> open </button>
            <button id="done" ${filter == 'done' ? 'class="active"' : ''}
                title="view only done todos" > done </button>           
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
             <c:forEach items="${todos}" var="item">  
                <tr>
                     <td>
                         <i class="icon-checkbox${item.finalizado ? ' ' : '-unchecked'} fg-grayLight"></i>
                      </td>
                     <td>
                         <a href="/tasks/${item.id}"> <c:out value="${item.nombre}"/> </a>
                     </td>
                     <td>${item.prioridad}</td>
                </tr>
             </c:forEach>  
         </tbody>
        </table>
    </jsp:attribute>
    
</t:taskapp-layout>