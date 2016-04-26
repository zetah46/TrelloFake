<%-- 
    Document   : login
    Created on : 26-abr-2016, 12:02:24
    Author     : elmen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String error;

    error = (String) request.getAttribute("error");
    if (error == null) {

        error = "";
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta charset = 'utf-8'>
    </head>
    <body>
        <form name="LoginServlet" action="LoginServlet" method="post">
            <div class="login">
                <br />Usuario: <input name="usuario" type="text" value="" onclick="if (this.value == 'Usuario')
                            this.value = ''" onblur="if (this.value == '')
                                        this.value = 'Usuario'">
                <br /> <br/>
                Contraseña: <input name="clave" type="password" value="" onclick="this.value = ''">
                <br /><br/>
                <p style="color:red"><%=error%></p>
                <button class="login" title="Acceder">Acceder</button> </div>
        </form>
    </body>
</html>
