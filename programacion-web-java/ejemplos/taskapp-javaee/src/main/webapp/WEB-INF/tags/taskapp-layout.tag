<%@ attribute name="title"                required="true" %>
<%@ attribute name="pageScript"           required="false" %>
<%@ attribute name="navigationBarActions" required="true" fragment="true" %>
<%@ attribute name="mainBody"             required="true" fragment="true" %>

<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/metroui/2.0.23/min/metro-bootstrap.min.css" >
   <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/metroui/2.0.23/min/metro-responsive.min.css" >

   <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.0/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.10.4/ui/minified/jquery.ui.widget.min.js"></script>      
   <script src="${pageContext.request.contextPath}/webjars/metroui/2.0.23/min/metro.min.js"></script>
   
   <c:if test="${not empty pageScript}">
      <script src="${pageScript}"></script>
   </c:if>   
   
   <title>${title}</title>
</head>
<body class="metro">
   <header>
      <nav class="navigation-bar">
         <nav class="navigation-bar-content container">        
            <a class="element" href="${pageContext.request.contextPath}/tasks">
               <span class="icon-list"></span> <span> taskapp </span>
            </a> 
            
            <jsp:invoke fragment="navigationBarActions" />
            
            <a title="info" class="element place-right" href="#"> 
                  <span class="icon-info-2"></span>
            </a> 
            <a title="author" class="element place-right" href="#"> 
                 <span	class="icon-at"></span>
            </a>                  
         </nav>
      </nav>
   </header>

   <div class="container">
       <jsp:invoke fragment="mainBody" />
   </div>

</body>
</html>