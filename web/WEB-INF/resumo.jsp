
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informações do Pedido</title>
        <%@include file="jspf/head.jspf" %>
    </head>
    <body>
        <h1>Informação do Pedido: ${pedido.descricao}</h1>
        <table class="table table-light">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Horário de Abertura</th>
                    <th>Horário de Fechamento</th>
                    <th>Número de Itens do pedido</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${pedido.id}</td>
                    <td>${pedido.descricao}</td>
                    <td>${pedido.hora_abertura}</td>
                    <td>${pedido.hora_fechamento}</td>
                    <td>${fn:length(pedido.itemPedido)}</td>
                </tr>
            </tbody>
        </table>
        <h3>Itens</h3>
        <table class="table table-light">
            <thead>
                <tr class="bg-primary">
                    <th>ID</th>
                    <th>Descrição do Produto</th>
                    <th>Valor do Produto</th>
                    <th>Quantidade</th>
                    <th>Valor Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${pedido.itemPedido}">
                    <tr class="bg-success text-white">
                        <td>${item.id}</td>
                        <td>${item.produto.descricao}</td>
                        <td>${item.produto.valor}</td>
                        <td>${item.quantidade}</td>
                        <td>${item.valorTotal}</td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
        <div class="d-print-none">
            <a href="#" onclick="window.print()" class="btn btn-success">Imprimir</a>
            <a href="pedidos.html?mesa=${mesaPedido.id}" class="btn btn-danger">Voltar</a>
        </div>
    </body>
</html>
