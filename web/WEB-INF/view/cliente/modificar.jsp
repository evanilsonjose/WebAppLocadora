<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Modificar Cliente - Locadora</title>
    </head>
    <body>
        <div class="formContainerAddModel1">
            <fieldset>
                <legend>Modificar Cliente</legend>
                <form action="${pageContext.request.contextPath}/cliente/modificar" method="post">
                    <input type="hidden" name="id" value="${cliente.getId()}">
                    <label>Nome:</label>
                    <br>
                    <input type="text" name="nome" size="45" maxlength="45" placeholder="Ex: João Pedro" value="${cliente.getNome()}">
                    <br><br>
                    <label>CNH:</label>
                    <br>
                    <input type="text" name="cnh" size="11" maxlength="11" placeholder="Ex: 20987123456" value="${cliente.getCnh()}">
                    <br><br>
                    <label>Endereço:</label>
                    <br>
                    <input type="text" name="endereco" size="60" maxlength="60" placeholder="Ex: Rua Joaquim Felipe, n1023" value="${cliente.getEndereco()}">
                    <br><br>
                    <div>
                        <div class="formContentBairro">
                            <label>Bairro:</label>
                            <br>
                            <input type="text" name="bairro" size="12" maxlength="30" placeholder="Ex: Boa Vista" value="${cliente.getBairro()}">
                        </div>
                        <div class="formContentCidade">
                            <label>Cidade:</label>
                            <br>
                            <input type="text" name="cidade" size="12" maxlength="30" placeholder="Ex: Recife" value="${cliente.getCidade()}">
                        </div>
                        <div class="formContentEstado">
                            <label>Estado:</label>
                            <br>
                            <select name="estado">
                                <option value="AL">AL</option>
                                <option value="PB">PB</option>
                                <option value="PE">PE</option>
                                <option value="RJ">RJ</option>
                                <option value="SP">SP</option>
                            </select>
                        </div>
                    </div>
                    <br><br>
                    <div class="formContentSubmit">
                        <input type="submit" value="Modificar">
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
