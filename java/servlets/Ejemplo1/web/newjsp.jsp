<%-- 
    Document   : newjsp
    Created on : 19/04/2016, 03:39:59 PM
    Author     : hernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        for(int i=1; i<=10;i++){
        out.print(i+"<br>");
        }    
        %>
    </body>
</html>
