<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Listar Usuário - Locadora</title>
    </head>
    <body>
        <div class="formContainerLstModel1">
            <fieldset>
                <legend>Lista de Usuários</legend>
                <table align="center">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>E-mail</th>
                            <th>Nome</th>
                            <th colspan="2">Operação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="l" varStatus="i">
                            <c:choose>
                                <c:when test="${i.count % 2 == 0}">
                                    <tr align="center" bgColor="#FFFFFF">
                                    </c:when>
                                    <c:otherwise>
                                    <tr align="center" bgColor="#F0F0F0">
                                    </c:otherwise>
                                </c:choose>
                                <td width="50">${l.id}</td>
                                <td width="300">${l.email}</td>
                                <td width="300">${l.nome}</td>
                                <td width="75"><a href="${pageContext.request.contextPath}/usuario/modificar?id=${l.id}">Modificar</a></td>
                                <td width="75"><a href="${pageContext.request.contextPath}/usuario/excluir?id=${l.id}">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
            <br>
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
