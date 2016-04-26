<%-- 
    Document   : register
    Created on : 26-abr-2016, 16:54:24
    Author     : elmen
--%>

<%
    String error;

    error = (String) request.getAttribute("error");
    if (error == null) {

        error = "";
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
    </head>
    <body>
        <form name="RegisterServlet" action="RegisterServlet" method="post">
            <div class="register">
                <br />Nombre Completo: <input name="nombre" type="text" value="" onclick="if (this.value == 'Nombre')
                            this.value = ''" onblur="if (this.value == '')
                                        this.value = 'Nombre'">
                <br /> <br/>
                Email: <input name="email" type="email" value="" onclick="this.value = ''">
                <br /><br/>
                <p style="color:red"> <%=error%></p>
                <button class="login" title="Acceder">Acceder</button> </div>
        </form>
    </body>
</html>
