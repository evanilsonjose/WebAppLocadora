<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Adicionar Usuário - Locadora</title>
    </head>
    <body>
        <div class="formContainerAddModel1">
            <fieldset>
                <legend>Inserir Usuário</legend>
                <form action="${pageContext.request.contextPath}/usuario/adicionar" method="post">
                    <label>Nome:</label>
                    <br>
                    <input type="text" name="nome" size="45" maxlength="45" placeholder="digite o nome">
                    <br><br>
                    <label>E-mail:</label>
                    <br>
                    <input type="text" name="email" size="45" maxlength="45" placeholder="digite o email">
                    <br><br>
                    <label>Senha:</label>
                    <br>
                    <input type="password" name="senha" size="12" maxlength="12" placeholder="digite a senha">
                    <br><br>
                    <label>Confirme a senha:</label>
                    <br>
                    <input type="password" name="confirmaSenha" size="12" maxlength="12" placeholder="confirme a senha">
                    <br><br>
                    <input type="submit" value="Cadastrar">
                </form>
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
