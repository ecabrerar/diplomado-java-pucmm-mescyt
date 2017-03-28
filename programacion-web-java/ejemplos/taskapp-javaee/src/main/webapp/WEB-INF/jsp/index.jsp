<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/metroui/2.0.23/min/metro-bootstrap.min.css" >
   <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/metroui/2.0.23/min/metro-responsive.min.css" >

   <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.0/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.10.4/ui/minified/jquery.ui.widget.min.js"></script>  
   <script src="${pageContext.request.contextPath}/webjars/metroui/2.0.23/min/metro.min.js"></script>
   
   <title>tasksapp</title>
</head>
<body class="metro bg-cyan">
 

  <div class="container" >
    <div class="grid">
      <div class="row">
        <div class="span1"></div>
        <div class="span5">
          <img src="/taskapp/static/images/task.png" style="padding: 10px 5px;"/>
        </div>
        <div class="span5" style="">
             <h1 style="margin-top: 10px">tasksapp</h1>
             <h2 style="padding: 20px 0px">
                 Esta es una aplicación demo con fines de demostrar los conceptos
                 de JPA, CDI y Servicios REST en Java.
             </h2>   
              
         </div>   
        </div> 
   
       <div class="row">
            <a class="tile bg-green" style="height: 180px; width: 400px" href="${pageContext.request.contextPath}/tasks">
                <div class="tile-content padded " >
                    <h2 class="fg-white" style="font-size: 3rem">/tasks</h2>                
                </div>
                 <div class="fg-white" style="font-size: 1.2em; position: absolute; bottom: 10px; right: 10px">
                    aplicación web  <i class="icon-arrow-right-3"></i>
                </div>   
            </a>    
          
            <a class="tile bg-amber" style="height: 180px; width: 400px"  href="${pageContext.request.contextPath}/api/tasks">          
                <div class="tile-content padded " >
                    <h2 class="fg-white" style="font-size: 3rem">{ api }</h2>              
                </div>
                <div class="fg-white" style="font-size: 1.2em; position: absolute; bottom: 10px; right: 10px">
                   rest api <i class="icon-arrow-right-3"></i>
                </div>   
            </a>  
         
        </div>    
   
    </div> 
  </div> 
 
</body>
</html>