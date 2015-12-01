<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Excluir Veículo - Locadora</title>
    </head>
    <body>
        <div class="formContainerAddModel1">
            <fieldset>
                <legend>Excluir Veículo</legend>
                <form action="${pageContext.request.contextPath}/veiculo/excluir" method="post">
                    <input type="hidden" name="id" value="${veiculo.getId()}">
                    <label>Placa:</label>
                    <br>
                    <input type="text" name="placa" size="10" maxlength="7" value="${veiculo.getPlaca()}" readonly="">
                    <br><br>
                    <label>Fabricante:</label>
                    <br>
                    <input type="text" name="fabricante" size="10" maxlength="7" value="${veiculo.getFabricante()}" readonly="">
                    <br><br>
                    <label>Modelo:</label>
                    <br>
                    <input type="text" name="modelo" size="15" maxlength="15" value="${veiculo.getModelo()}" readonly="">
                    <br><br>
                    <label>Valor do Aluguel(diária):</label>
                    <br>
                    <input type="text" name="valorAluguel" size="10" maxlength="6" value="${veiculo.getValorAluguel()}" readonly="">
                    <br><br>
                    <input type="submit" value="Excluir">
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
