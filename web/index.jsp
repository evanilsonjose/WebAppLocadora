<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/dashboardStyle.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/dashboardMenuStyle.css">
        <title>Dashboard - Locadora</title>
    </head>
    <body>
        <div class="conteinerDashboard">
            <h1 class="titleDashboard">Locadora</h1>
            <h2 class="acessoMenu">Dashboard</h2>
            <div class="menuDashboard">
                <ul class="menu"> <!-- Esse é o 1 nivel ou o nivel principal -->
                    <li>
                        <a href="#">Usuário</a>
                        <ul class="submenu-1"> <!-- Esse é o 2 nivel ou o primeiro Drop Down -->
                            <li><a href="${pageContext.request.contextPath}/usuario/adicionar">Inserir</a></li>
                            <li><a href="${pageContext.request.contextPath}/usuario/buscar">Buscar</a></li>
                            <li><a href="${pageContext.request.contextPath}/usuario/listar">Listar</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Cliente</a>
                        <ul class="submenu-1"> <!-- Esse é o 2 nivel ou o primeiro Drop Down -->
                            <li><a href="${pageContext.request.contextPath}/cliente/adicionar">Inserir</a></li>
                            <li><a href="${pageContext.request.contextPath}/cliente/buscar">Buscar</a></li>
                            <li><a href="${pageContext.request.contextPath}/cliente/listar">Listar</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Veículo</a>
                        <ul class="submenu-1"> <!-- Esse é o 2 nivel ou o primeiro Drop Down -->
                            <li><a href="${pageContext.request.contextPath}/veiculo/adicionar">Inserir</a></li>
                            <li><a href="${pageContext.request.contextPath}/veiculo/buscar">Buscar</a></li>
                            <li><a href="${pageContext.request.contextPath}/veiculo/listar">Listar</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>