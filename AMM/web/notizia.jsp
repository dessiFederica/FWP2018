<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="style.css" >
    </head>
    <body>

        <header>
<!--            <img float="left" height="200px" src="jobs.jpg" alt=""/>
            <login>
                <c:if test="${isLogged == true}">
                      <form>
                          <p>Bentornato ${username}! 
                          <button float="right" type="submit" name="logout" formaction="Logout" method="POST" value="${username}">Logout</button>
                      </form>
                      <form  action="Profilo" method="POST">
                          <button float="right" type="submit" name="ilMioProfilo" formaction="Profilo" method="POST" value="${username}">Profilo</button>
                          </form>
                          <form  action="News" method="POST">
                              <button float="right" type="submit" name="leMieNotizie" formaction="News" method="POST" value="Notizie">Notizie</button>
                          </form>
                          <form  action="Articles" method="POST">
                              <button float="right" type="submit" name="iMieiArticoli" formaction="Articles" method="POST"  value="${username}">I Miei Articoli</button>
                          </form></p>  
                </c:if>
                <c:if test="${isLogged == false}">
                    <c:redirect url="/login.jsp" />
                </c:if>
            </login>-->
 <jsp:include page="header.jsp" />
        </header>


        <section>
            <nav>
                <jsp:include page="nav.jsp" />
            </nav>

            <content>
                <h2>Notizie</h2> 
                <div class="grid-container">
                    <c:forEach items="${listaArticoli}" var="articolo">
                        <div>
                            <form action="NewsDetail" method="POST">
                            <h3>${articolo.titolo}</h3>
                            <img src="${articolo.img}" height="150"/>
                            <p>${articolo.didascalia}</p>
                            <p>${articolo.categoria} - <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${articolo.dataPubblicazione}" /></p>
                            <p>${fn:substring(articolo.contenuto, 0, 100)} ... </p>
                            <!--<p>${articolo.contenuto}</p>-->
                            <button type="submit" name="articolo" value="${articolo.id}" data-value="${username}">View More</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </content>
        </section>

        <footer>
            <p>Footer</p>
        </footer>

    </body>
</html>

