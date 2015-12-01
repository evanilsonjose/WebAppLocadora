<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Excluir Cliente - Locadora</title>
    </head>
    <body>
        <div class="formContainerAddModel1">
            <fieldset>
                <legend>Excluir Cliente</legend>
                <form action="${pageContext.request.contextPath}/cliente/excluir" method="post">
                    <input type="hidden" name="id" value="${cliente.getId()}">
                    <label>Nome:</label>
                    <br>
                    <input type="text" name="nome" size="45" maxlength="45" value="${cliente.getNome()}" readonly="">
                    <br><br>
                    <label>CNH:</label>
                    <br>
                    <input type="text" name="cnh" size="11" maxlength="11" value="${cliente.getCnh()}" readonly="">
                    <br><br>
                    <label>Endereço:</label>
                    <br>
                    <input type="text" name="endereco" size="60" maxlength="60" value="${cliente.getEndereco()}" readonly="">
                    <br><br>
                    <div>
                        <div class="formContentBairro">
                            <label>Bairro:</label>
                            <br>
                            <input type="text" name="bairro" size="12" maxlength="30" value="${cliente.getBairro()}" readonly="">
                        </div>
                        <div class="formContentCidade">
                            <label>Cidade:</label>
                            <br>
                            <input type="text" name="cidade" size="12" maxlength="30" value="${cliente.getCidade()}" readonly="">
                        </div>
                        <div class="formContentEstado">
                            <label>Estado:</label>
                            <br>
                            <input type="text" name="estado" size="4" maxlength="2" value="${cliente.getEstado()}" readonly="">
                        </div>
                    </div>
                    <br><br>
                    <div class="formContentSubmit">
                        <input type="submit" value="Excluir">
                    </div>
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
