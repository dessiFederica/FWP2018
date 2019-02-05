<%-- 
    Document   : nav
    Created on : 25-ago-2018, 14.26.57
    Author     : federicadessi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="style.css" > 
    </head>
    <body>
        <div class="grid-container-nav">
        <div id="cerca" class="cerca">
            <label>Cerca:</label><br>
             <input type="text" name="cerca">
        </div>
        <div id="categorie">
            <hr><h3>Categorie</h3> 
            <ol>
                <li>Apple</li>
                <li>Samsung</li>
                <li>Huawei</li>
                <li>Lg</li>
                <li>Xiaomi</li>
                <li>Microsoft</li>
                <li>Amazon</li>
                <li>Facebook</li>
            </ol>
        </div>
        <div id="autori">
            <hr><h3>Autori</h3> 
            <ol>
                <li>Federica Dessì</li>
                <li>Patrizio Marras</li>
                <li>Andrea Visca</li>
            </ol>
        </div>
        </div>
    </body>
</html>
