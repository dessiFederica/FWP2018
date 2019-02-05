<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Articoli</title>
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
                <h2>Articoli</h2>
                <table>
                    <tr>
                        <th>Data</th>
                        <th>Titolo</th> 
                        <th>Modifica</th>
                        <th>Elimina</th>
                    </tr>
                     <c:forEach items="${listaArticoli}" var="articolo">
                       <c:if test="${listalength != 0}"> 
                        <tr>
                            <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${articolo.dataPubblicazione}" /></td>
                            <td>${articolo.titolo}</td>
                            <td><input type="image" src="modifica.png" alt="Modifica" width="20" height="20"></td>
                        <td><input type="image" src="cestino.png" alt="Elimina" width="20" height="20"></td>
                        </tr>
                        </c:if>
                        <c:if test="${listalength != 0}">
                            <tr>
                            <td>Nessun Articolo</td>
                        </tr>
                        </c:if>
                    </c:forEach>
                </table>
                <div>
                    <form action="NewArticle" method="POST">
                          <button type="submit" name="nuovo" value="${username}">Scrivi Articolo</button>
                    </form>
                </div>
            </content>
        </section>

    </body>
</html>
