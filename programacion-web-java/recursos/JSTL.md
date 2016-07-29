**JSTL (JavaServer pages Standard Tag Library)**

A partir de JSP 1.2. se introduce un conjunto de librerías en la especificación, pasando a ser estándar.

JSTL consta de los siguientes grupos de etiquetas:

```html
http://java.sun.com/jsp/jstl/core

http://java.sun.com/jsp/jstl/xml

http://java.sun.com/jsp/jstl/fmt

http://java.sun.com/jsp/jstl/sql	
```

**Expression language (EL)**

**JSTL** define un lenguaje de expresiones (EL), que facilita enormemente el tratamiento de información.

Las expresiones se indican de la forma **${expresion}**.

**Librería**  __**core**__

En las páginas que la usen debemos incluir la siguiente directiva:

```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

**out**

```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br> <c:out value="1+2+3"/>

<br> <c:out value="${1+2+3}"/>

<br> <c:out value="${param.nombreParametro}"/>

<br> <c:out value="${sessionScope.variableDeSesion}"/> 
```

**set**

Guarda información en una variable, tiene los siguientes atributos:

- **var**. Nombre de la variable

- **scope**. Ámbito de la variable, admite los valores **page**, **session** y **application**.
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:set var="variableDePagina" scope="page">

Esta información se guarda en la página

</c:set>

${variableDePagina}
```
**if**

Procesa el cuerpo de la etiqueta si la condición se evalúa a cierto. La condición se indica en el atributo

**test**

Ejemplo:
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty param.nombre}">

Parámetro 'nombre' no definido.

</c:if>	
```
**choose, when y otherwise**

Procesa condiciones múltiples, se procesa el cuerpo del primer **when** cuya condición especificada en el atributo **test** se evalúa si es cierto.

Si ninguna de las condiciones se cumple, se procesa el cuerpo de **otherwise** en caso de que aparezca.

Ejemplo:
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>

<c:when test="${empty param.nombre}">

Parámetro 'nombre' no definido.

</c:when>

       <c:otherwise>

   	Valor del parámetro 'nombre':${param.nombre}

</c:otherwise>

</c:choose>
```
**forEach y forTokens** 

**forEach** consta de los siguientes atributos:

- **items**. Indica la colección sobre la que iterar

- **var**. Indica el nombre de la variable donde se guardará el elemento en curso.

- **varStatus**. Indica el nombre de la variable donde se guardará el estado de la iteración.

En cada iteración, la variable indicada en var irá tomando el valor del elemento en curso.

A través de la variable indicada en **varStatus** podemos acceder a las siguientes propiedades:

- **index**. Posición del elemento en curso (comienza con 0).

- **count**. Número de iteraciones (comienza con 1).

- **first**. Valor booleano que indica si es la primera iteración.

- **last**. Valor booleano que indica si es la última iteración.

**forTokens** permite partir una cadena en fragmentos y recorrer cada uno de éstos, consta de los

siguientes atributos:

- **items**. Cadena que se quiere tokenizar.

- **var**. Indica el nombre de la variable donde se guardará el fragmento en curso.

- **delims**. Cadena con todos los caracteres que actúan como delimitador.

- **varStatus**. Indica el nombre de la variable donde se guardará el estado de la iteración.

 Ejemplo:
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${header}" var="cabecera">

${cabecera}

</c:forEach>

<%

String []cadenas={"uno","dos","tres"};

pageContext.setAttribute("cadenas",cadenas);

%>

<c:forEach items="${pageScope.cadenas}" var="cadena">

${cadena}

</c:forEach>

<c:forEach items="${param}" var="parametro">

Nombre: ${parametro.key}

Valor: ${parametro.value}

</c:forEach>

<c:forTokens items="cero, uno, dos, tres, cuatro, cinco" var="token" varStatus="status" delims=",">

${status.index}.- ${token}

</c:forTokens>
```
**redirect**

Redirige a la dirección especificada en el atributo url, y aborta el procesamiento de la página actual.

Ejemplo:
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${param.clave!='secreto'}">

<c:redirect url="login.jsp"/>

</c:if>
```
**Control de errores con** __**catch**__

Con **<c:catch>** podemos capturar excepciones, sin que se aborte la ejecución de la página al

producirse un error.
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:catch var="error01">

<%=Integer.parseInt(request.getParameter("parametro"))%>

</c:catch>

<c:if test="${not empty error01}">

Se produjo un error: ${error01}

</c:if>
```
**Librería** __**formatting**__

Contiene etiquetas que realizan diversas funciones relacionadas con formato y localización,

comentamos únicamente **formatDate** y **formatNumber**.

La directiva para poder utilizarla es:
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
```

**formatDate**

Permite formatear fechas. Tiene, entre otros, los siguientes atributos:

- **type**. Permite los valores time (sólo hora), date (sólo fecha) y both (ambos).

  El valor por defecto es date.

**-pattern**. Permite controlar el formato, podemos ver cómo estructurarlo en la clase

**java.text.SimpleDateFormat** del API de Java.

**value**. La fecha en sí o la variable que la contiene.

Ejemplo
```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%pageContext.setAttribute("fecha",new java.util.Date());%>

Hoy es:

<fmt:formatDate value="${pageScope.fecha}" pattern="dd/MM/yyyy"/>
```
