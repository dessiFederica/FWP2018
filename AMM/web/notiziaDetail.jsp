<%-- 
    Document   : notiziaDetail
    Created on : 26-ago-2018, 12.59.09
    Author     : federicadessi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
                <div>
                    <h2>${articoloDetail.titolo}</h2>
                    <img  src="${articoloDetail.img}" height="150" alt="Apple"/>
                        <p id="didascalia">${articoloDetail.didascalia}</p>
                        <p>${articoloDetail.categoria} - <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${articoloDetail.dataPubblicazione}" /></p><p>${articoloDetail.autore.nome} ${articoloDetail.autore.cognome}</p>
                        <p id="testoArticolo">${articoloDetail.contenuto}</p>
                </div>
            </content>
        </section>

        <footer>
            <p>Footer</p>
        </footer>

    </body>
</html>

