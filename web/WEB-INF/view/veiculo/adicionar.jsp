<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Adicionar Veículo - Locadora</title>
    </head>
    <body>
        <div class="formContainerAddModel1">
            <fieldset>
                <legend>Inserir Veículo</legend>
                <form action="${pageContext.request.contextPath}/veiculo/adicionar" method="post">
                    <label>Placa:</label>
                    <br>
                    <input type="text" name="placa" size="10" maxlength="7" placeholder="Ex: NGQ9547">
                    <br><br>
                    <label>Fabricante:</label>
                    <br>
                    <select name="fabricante">
                        <option value="Audi">Audi</option>
                        <option value="Fiat">Fiat</option>
                        <option value="Ford">Ford</option>
                        <option value="Honda">Honda</option>
                        <option value="Hyundai">Hyundai</option>
                        <option value="Peugeot">Peugeot</option>
                        <option value="Renault">Renault</option>
                        <option value="Volkswagen">Volkswagen</option>
                    </select>
                    <br><br>
                    <label>Modelo:</label>
                    <br>
                    <input type="text" name="modelo" size="15" maxlength="15" placeholder="Ex: Palio, Clio, Gol">
                    <br><br>
                    <label>Valor do Aluguel(diária):</label>
                    <br>
                    <input type="text" name="valorAluguel" size="10" maxlength="6" placeholder="Ex: 250.00">
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
