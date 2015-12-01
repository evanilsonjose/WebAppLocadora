<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Adicionar Cliente - Locadora</title>
    </head>
    <body>
        <div class="formContainerAddModel1">
            <fieldset>
                <legend>Inserir Cliente</legend>
                <form action="${pageContext.request.contextPath}/cliente/adicionar" method="post">
                    <label>Nome:</label>
                    <br>
                    <input type="text" name="nome" size="45" maxlength="45" placeholder="Ex: João Pedro">
                    <br><br>
                    <label>CNH:</label>
                    <br>
                    <input type="text" name="cnh" size="11" maxlength="11" placeholder="Ex: 20987123456">
                    <br><br>
                    <label>Endereço:</label>
                    <br>
                    <input type="text" name="endereco" size="60" maxlength="60" placeholder="Ex: Rua Joaquim Felipe, n1023">
                    <br><br>
                    <div>
                        <div class="formContentBairro">
                            <label>Bairro:</label>
                            <br>
                            <input type="text" name="bairro" size="12" maxlength="30" placeholder="Ex: Boa Vista">
                        </div>
                        <div class="formContentCidade">
                            <label>Cidade:</label>
                            <br>
                            <input type="text" name="cidade" size="12" maxlength="30" placeholder="Ex: Recife">
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
                        <input type="submit" value="Cadastrar">
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
