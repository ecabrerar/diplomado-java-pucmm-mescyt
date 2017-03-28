<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:taskapp-layout title="task item"
                   pageScript="${pageContext.request.contextPath}/static/js/task-form.js">
 
    <jsp:attribute  name="navigationBarActions">           
		<a title="Salvar" class="element" href="#" id="salvar"> <span
			class="icon-checkmark on-left"></span><span>aceptar</span>
		</a> 			
		<a title="Cancelar" class="element" href="${pageContext.request.contextPath}/tasks"> <span
			class="icon-undo on-left"></span><span>cancelar</span>
		</a>
		
		<c:if test="${!empty task}">
			<form id="borrarForm" method="POST">
			    <input type="hidden" name="action" value="borrar" />
			</form>    
			<a title="Borrar" class="element" href="#" id="borrar"> <span
				class="icon-cancel-2 on-left"></span><span>borrar</span>
			</a> 
		</c:if>
    </jsp:attribute>

    <jsp:attribute  name="mainBody"> 
      	<h1>
			<i class="icon-clipboard fg-darker smaller"></i>
			task-list<small class="on-right">item</small>
		</h1>

		<form class="span10" id="taskForm" method="POST">
		    <input type="hidden" name="action"  value="salvar" />
                       
			<label>Nombre <span class="fg-red" id="nameMessage"></span></label>
			<div class="input-control text" data-role="input-control" id="nameControl">
				<input type="text" placeholder="nombre" id="name" name="nombre" value="${task.nombre}"></input>
				<button class="btn-clear" tabindex="-1" type="button"></button>			
			</div>

			<label>Descripcion</label>
			<div class="input-control textarea" data-role="input-control">
				<textarea name="descripcion">${task.descripcion}</textarea>
			</div>

			<label>Prioridad</label>
			<div class="input-control select">
				<select name="prioridad">
				    <option value="">  </option>
					<option value="Alta"   ${task.prioridad == 'Alta' ? 'selected':''}>Alta</option>
					<option value="Normal" ${task.prioridad == 'Normal' ? 'selected':''}>Normal</option>
					<option value="Baja"    ${task.prioridad == 'Baja' ? 'selected':''}>Baja</option>
				</select>
			</div>

			<label class="nbm">Terminada</label>
			<div class="input-control checkbox" data-role="input-control">
				<label> <input type="checkbox" name="finalizado" ${task.finalizado==1? 'checked' : ''}/> <span class="check"></span>
				</label>
			</div>

		</form>
                
        <c:if test="${not empty errorText}">
            <script type="text/html" id="errorContent">        
                <label> ${errorText} </label>
                <div class="form-actions place-right padding25">
                    <button class="button primary" onclick="location.reload()">Refrescar</button>
                    <button class="button" type="button" onclick="$.Dialog.close()">Cancelar</button>
                </div>        
            </script>
        </c:if>        
          
    </jsp:attribute>
    
</t:taskapp-layout>