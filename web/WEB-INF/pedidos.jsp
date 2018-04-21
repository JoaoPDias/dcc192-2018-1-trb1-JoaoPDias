<%-- 
    Document   : mesas
    Created on : 20/04/2018, 22:14:45
    Author     : jpdia
--%>
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
            <th>Horário de Abertura</th>
            <th>Horário de Fechamento</th>
            <th>Número de Itens do pedido</th>
            <th>Opções</th>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${fn:length(pedidos)!=0}">
                    <c:forEach var="pedido" items="${pedidos}">
                        <tr>
                            <td>${pedido.id}</td>
                            <td>${pedido.descricao}</td>
                            <td>${pedido.hora_abertura}</td>
                            <td>${pedido.hora_fechamento}</td>
                            <td>${fn:length(pedido.itemPedido)}</td>
                            <td><a href="itens.html?pedido=${pedido.id}">Incluir/Visualizar Itens</a></td>
                        </tr>
                    </c:forEach>
                </c:when>
                    <c:when test="${fn:length(pedidos)==0}">
                    <td colspan="6">Não há Pedidos cadastrados nessa Mesa. Adicione um!</td> 
                    </c:when>
            </c:choose>
        </tbody>
        <tfoot><a href="adicionarPedido.html">Adicionar Pedido</a></tfoot>
    </table>
</body>
</html>
