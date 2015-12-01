<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Buscar Usuário - Locadora</title>
    </head>
    <body>
        <div class="formContainerSeaModel1">
            <fieldset>
                <legend>Buscar Usuário</legend>
                <form action="${pageContext.request.contextPath}/usuario/buscar" method="get">
                    <center>
                        <input type="number" name="id">
                        <input type="submit" value="buscar">
                    </center>
                </form>
                <br>
                <c:if test="${!(empty usuario)}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th width="425">Nome</th>
                                <th width="425">E-mail</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr align="center">
                                <td>${usuario.nome}</td>
                                <td>${usuario.email}</td>
                            </tr>
                        </tbody>
                    </table>
                </c:if>
            </fieldset>
            <center>
                <% String msg = (String) request.getAttribute("msg");%>
                <c:if test="${!(empty msg)}">
                    <p class='msgLoginAlert'><%=msg%></p>
                </c:if>
            </center>
            <br>
            <center>
                <div><a href="${pageContext.request.contextPath}/index.jsp">voltar para Dashboard</a></div>
            </center>
        </div>
    </body>
</html>
