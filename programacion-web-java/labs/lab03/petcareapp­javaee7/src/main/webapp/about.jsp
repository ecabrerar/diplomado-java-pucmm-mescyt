<%-- 
    Document   : about
    Created on : Aug 6, 2016, 4:47:47 PM
    Author     : ecabrerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="public" tagdir="/WEB-INF/tags" %>

<public:jumbotron-layout title="Sobre Nosotros">

    <jsp:attribute name="mainBody">
        <div​ class​="container"> 
            <h1>​ PetCare​ </h1> 
            <p​ class​="lead"> 

                PetCare​  es una aplicaci​ ó ​ n demo con fines demostrar conceptos b​ á ​ sicos en el 
                desarrollo de aplicaciones web en ​ Java. 

        </p> 


        <div​ class​="row marketing"> 
            <div​   ​ class​="col­lg­6"> 
                <h2>​ JSR 340​ </h2> 
                <p>​ Java Servlets 3.1.​ </p> 

                <h2>​ JSR 338​ </h2> 
                <p>​ Java Persistence API 2.1 ​ </p> 

            </div> 

            <div​   ​ class​ = ​ "col­lg­6">         <h2>​ Requerimientos​ </h2>    <p>​ Java 1.8 +​ </p>    
                <p>​ Netbeans 8.0.2+​ </p>    
                <p>​ Glassfish 4.1.1 +​ </p>    <p>​ Mysql Server 5.0+​ </p>    <p>​ Apache Maven 3.2.1+ ​ </p> 


            </div> 
        </div> 
        <div> 
            <h2>​ Características Adicionales​ </h2> 
            <p>​ La plantilla base es una combinacion de las plantillas carousel y jumbotron 
                de Twitter Bootstrap (Twitter Bootstrap 3.1.1)​ </p>

        </div> 
        <div> 
            <p>​ Autor: ​ <a​   ​ href​ = ​ "https://github.com/ecabrerar"​ > ​ [Eudris Cabrera]​ </a> 


            </p> 
        </div> 


        <div> 
            <h2>​ Enlaces​ </h2> 
            <ul> 
                <li><a​   ​ href​ = ​ "http://getbootstrap.com/getting­started/"​ > ​ Twitter 

                        Bootstrap​ </a></li> 

            </ul> 
        </div>  

    </jsp:attribute>

</public:jumbotron-layout>