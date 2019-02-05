<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <img float="left" height="200px" src="jobs.jpg" alt=""/>
            <login><form>
                <label>USERNAME:</label>
                <input type="text" name="username">
                <label>PASSWORD:</label>
                <input type="password" name="pasword">
                <input type="submit" value="Entra">
            </form>
        </login>
        </header>
        

        <section>
            <nav>
                <jsp:include page="nav.jsp" />
            </nav>

            <content>
                <%--<jsp:include page="notizia.jsp" />--%>
            </content>
        </section>

        <footer>
            <p>Footer</p>
        </footer>

    </body>
</html>

