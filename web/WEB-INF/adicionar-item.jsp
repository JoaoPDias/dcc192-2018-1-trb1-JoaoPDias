<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="jspf/head.jspf" %>
    <body>
        <h1>Adicionar Item</h1>
        <form method="post">
            <div class="form-group">
                <label for="mesa">Mesa</label>
                <input type="text" name="mesa" id="mesa" readonly="readonly" class="form-control col-md-4" value="${mesa.descricao}" />
            </div>
            <div class="form-group">
                <label for="pedido">Pedido</label>
                <input type="text" name="pedido" id="pedido" readonly="readonly" class="form-control col-md-4" value="${pedido.descricao}" />
            </div>
            
            <div class="form-group">
                <label>Produto</label>
                <select id="produto" name="produto" class="form-control col-md-4">
                    <c:forEach var="prod" items="${produtos}">
                    <option value="${prod.id}">Produto: ${prod.descricao}, Valor: ${prod.valor}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="quantidade">Quantidade</label>
                <input type="text" name="quantidade" id="quantidade" class="form-control col-md-4"/>
            </div>
            <input type="hidden" name="operacao" value="incluir">
            <button type="submit" class="btn btn-success">Salvar</button>
            <a href="itens.html?mesaPedido=${mesa.id}&pedido=${pedido.id}" class="btn btn-danger">Voltar</a>
            
        </form>
    </body>
</html>
