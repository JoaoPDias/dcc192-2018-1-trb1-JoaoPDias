
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="jspf/head.jspf" %>
    <body>
        <table>
            <thead>
            <th>ID</th>
            <th>Descrição</th>
            <th>Número de Pedidos</th>
            </thead>
            <tbody>
                <c:forEach var="mesa" items="${mesas}">
                    <tr>
                        <td>${mesa.id}</td>
                        <td>${mesa.descricao}</td>
                        <td>${fn:length(mesa.pedido)}</td>
                        <td><a href="pedidos.html?mesa=${mesa.id}">Incluir/Visualizar Pedidos</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
