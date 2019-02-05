<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
            <img float="left" height="200px" src="jobs.jpg" alt=""/>
            <login>
                <c:if test="${isLogged == true}">
                      <form>
                          <p>Bentornato ${username}! 
                          <button float="right" type="submit" name="logout" formaction="Login" method="POST" value="${username}">Logout</button>
<!--                      </form>-->
<!--                      <form  action="Profilo" method="POST">-->
                          <button float="right" type="submit" name="profile" formaction="Profilo" method="POST" value="${username}">Profilo</button>
<!--                          </form>-->
<!--                          <form  action="News" method="POST">-->
                              <button float="right" type="submit" name="leMieNotizie" formaction="Notizie" method="POST" value="Notizie">Notizie</button>
<!--                          </form>
                          <form  action="Articles" method="POST">-->
                              <button float="right" type="submit" name="iMieiArticoli" formaction="Articles" method="POST"  value="${username}">I Miei Articoli</button>
                          </form></p>  
                </c:if>
                <c:if test="${isLogged == false}">
                    <c:redirect url="/login.jsp" />
                </c:if>
            </login>
    </body>
</html>
