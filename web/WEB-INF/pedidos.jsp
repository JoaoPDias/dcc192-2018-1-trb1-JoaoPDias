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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista do Pedidos da Mesa</title>
        <%@include file="jspf/head.jspf" %>
    </head>
    <body>
        <h1>Lista de Pedidos</h1>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Horário de Abertura</th>
                    <th>Horário de Fechamento</th>
                    <th>Valor Total do Pedido</th>
                    <th>Número de Itens do pedido</th>
                    <th colspan="2">Opções</th>
                </tr>
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
                                <td>${pedido.valorTotal}</td>
                                <td>${fn:length(pedido.itemPedido)}</td>
                                <td><a href="itens.html?mesaPedido=${mesaPedido.id}&pedido=${pedido.id}">Incluir/Visualizar Itens</a></td>
                                <c:choose>
                                    <c:when test="${!pedido.fechado}">
                                        <td><a href="fechar-pedido.html?mesaPedido=${mesaPedido.id}&pedido=${pedido.id}">Fechar Pedido</a></td>
                                    </c:when>
                                    <c:when test="${pedido.fechado}">
                                        <td><a href="fechar-pedido.html?mesaPedido=${mesaPedido.id}&pedido=${pedido.id}">Imprimir Pedido</a></td>
                                    </c:when>
                                </c:choose>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:when test="${fn:length(pedidos)==0}">
                        <tr>
                            <td colspan="6">Não há Pedidos cadastrados nessa Mesa. Adicione um!</td> 
                        </tr>
                    </c:when>
                </c:choose>
            </tbody>

        </table>
        <div>
            <c:choose>
                <c:when test="${requestScope.abertos=='false'}">
                    <a href="adicionar-pedidos.html?mesaPedido=${mesaPedido.id}" class="btn btn-success" >Adicionar Pedido</a>
                </c:when>
                <c:when test="${requestScope.abertos=='true'}">
                    <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Um Pedido está Aberto. Feche-o, para adicionar um novo">
                    <button class="btn btn-success" disabled="disabled" >Adicionar Pedido</button>
                    </span>
                </c:when>
            </c:choose>

            <a href="mesas.html" class="btn btn-danger">Voltar</a>
        </div>
    </body>
</html>
