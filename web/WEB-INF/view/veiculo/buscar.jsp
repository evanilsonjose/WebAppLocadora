<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/formStyle.css">
        <title>Buscar Veículo - Locadora</title>
    </head>
    <body>
        <div class="formContainerSeaModel1">
            <fieldset>
                <legend>Buscar Veículo</legend>
                <form action="${pageContext.request.contextPath}/veiculo/buscar" method="get">
                    <center>
                        <input type="number" name="id">
                        <input type="submit" value="buscar">
                    </center>
                </form>
                <br>
                <c:if test="${!(empty veiculo)}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th width="200">Placa</th>
                                <th width="225">Fabricante</th>
                                <th width="225">Modelo</th>
                                <th width="200">Aluguel R$</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr align="center">
                                <td>${veiculo.placa}</td>
                                <td>${veiculo.fabricante}</td>
                                <td>${veiculo.modelo}</td>
                                <td>${veiculo.valorAluguel}</td>
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
