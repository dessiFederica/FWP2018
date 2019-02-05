<%-- 
    Document   : profile
    Created on : 5-feb-2019, 20.37.44
    Author     : federicadessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profilo</title>
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
                <h2>Profilo</h2>
                <div>
                    <img src="${utente.urlProfImg}" height="150" alt="User"/>
                    <h1>${utente.nome}${utente.cognome}</h1>
                    <p>${utente.email}</p>
                    <p>${utente.tipologiaUtente}</p>
                </div>
            </content>
        </section>

    </body>
</html>
