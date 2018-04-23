
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Mesas</title>
        <%@include file="jspf/head.jspf" %>
    </head>
    <body>
        <h1>Lista de Mesas</h1>
        <table class="table bg-info text-white">
            <thead>
            <th>ID</th>
            <th>Descrição</th>
            <th>Número de Pedidos</th>
            <th>Opções</th>
        </thead>
        <tbody>
            <c:forEach var="mesa" items="${mesas}">
                <tr>
                    <td>${mesa.id}</td>
                    <td>${mesa.descricao}</td>
                    <td>${fn:length(mesa.pedido)}</td>
                    <td><a href="pedidos.html?mesa=${mesa.id}" class="text-white">Incluir/Visualizar Pedidos</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
