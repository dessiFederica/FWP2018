<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Scrivi Articolo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                <c:if test="${articolo.id == null}"> 
                    <form action="NewArticle" method="POST">
                        <label> Titolo: </label><br><input type="text" name="titolo"><br>
                        <label>Immagine: </label><br><input type="text" name="immagine"><br>
                        <label>Didascalia: </label><br><input type="text" name="didascalia"><br>
                        <label>Testo: </label><br><textarea rows="6"  name="testo"></textarea><br>
                        <label>Categoria: </label><br>
                        <input type="radio" name="cat" value="apple">Apple<br>
                        <input type="radio" name="cat" value="samsung">Samsung<br>
                        <input type="radio" name="cat" value="huawei">Huawei<br>
                        <input type="radio" name="cat" value="lg">Lg<br>
                        <input type="radio" name="cat" value="facebook">Facebook<br>
                        <input type="radio" name="cat" value="xiaomi">Xiaomi<br>
                        <input type="radio" name="cat" value="amazon">Amazon<br>
                        <button type="submit" name="salva" value="${username}">Salva</button><br>
                    </form>
                </c:if>

                <c:if test="${articolo.id != null}"> 
                    <form>
                        <label>Id Articolo:</label><br><span><p>${articolo.id}</p></span><br>
                        <label>Titolo: </label><br><span><p>${articolo.titolo}</p></span><br>
                         <label>Immagine: </label><br><span><p>${articolo.img}</p></span><br>
                          <label>Didascalia: </label><br><span><p>${articolo.contenuto}</p></span><br>
                            <label>Data Pubblicazione </label><br><span><p><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${articolo.dataPubblicazione}" /></p></span><br>
                           <label>Categoria: </label><br><span><p>${articolo.categoria}</p></span><br>
                    </form>
                </c:if>
            </content>
        </section>
    </body>
</html>
