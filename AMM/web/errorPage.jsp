<%-- 
    Document   : errorPage
    Created on : 17-set-2018, 17.26.48
    Author     : federicadessi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <title></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="style.css" > 
    </head>
    <body>
         <header>
           <jsp:include page="header.jsp" />
        </header>
        <section>
            <nav>
                <jsp:include page="nav.jsp" />
            </nav>
            <content>
            </content>
        </section>
    </body>
</html>
