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
        </header>
        

        <section>
            <nav>
                <jsp:include page="nav.jsp" />
            </nav>

            <content>
               <form action="Login" method="POST">
                   <h2>Login</h2>
                   <label>USERNAME:</label><br>
                <input type="text" name="username" value="f.dessi025"><br>
                <label>PASSWORD:</label><br>
                <input type="password" name="password" value="12345"><br>
                <input type="submit" value="Entra">
               </form>
            </content>
        </section>

        <footer>
            <p>Footer</p>
        </footer>

    </body>
</html>

