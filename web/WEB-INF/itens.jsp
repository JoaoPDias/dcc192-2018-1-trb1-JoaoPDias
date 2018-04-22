
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Itens do Pedido</title>
        <%@include file="jspf/head.jspf" %>
    </head>
    <body>
        <h1>Lista de Itens do Pedidos</h1>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição do Produto</th>
                    <th>Valor do Produto</th>
                    <th>Quantidade</th>
                    <th>Valor Total</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${fn:length(itens)!=0}">
                        <c:forEach var="item" items="${itens}">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.produto.descricao}</td>
                                <td>${item.produto.valor}</td>
                                <td>${item.quantidade}</td>
                                <td>${item.valorTotal}</td>
                                <td><a href="editar-item.html?mesa=${mesa.id}&pedido=${pedido.id}&item=${item.id}">Editar Item</a></td>
                                <td><a href="excluir-item.html?mesa=${mesa.id}&pedido=${pedido.id}&item=${item.id}">Excluir Item</a></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:when test="${fn:length(itens)==0}">
                        <tr>
                            <td colspan="7">Não há Itens cadastrados nesse Pedido. Adicione um!</td> 
                        </tr>
                    </c:when>
                </c:choose>
            </tbody>

        </table>
        <div>
            <a href="adicionar-item.html?mesa=${mesa.id}&pedido=${pedido.id}" class="btn btn-success">Adicionar Item</a>
            <a href="pedidos.html?mesa=${mesa.id}" class="btn btn-danger">Voltar</a>
        </div>
    </body>
</html>
