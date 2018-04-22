package Servlets;

import Modelos.ItemPedido;
import Modelos.Mesa;
import Modelos.Pedido;
import Modelos.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ItensServlet", urlPatterns = {"/itens.html", "/adicionar-item.html", "/editar-item.html", "/excluir-item.html"})
public class ItensServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/itens.html".equals(request.getServletPath())) {
            if (request.getParameter("mesaPedido") != null && request.getParameter("pedido") != null) {
                Integer mesa = Integer.parseInt(request.getParameter("mesaPedido"));
                Integer pedido = Integer.parseInt(request.getParameter("pedido"));
                Mesa mesaPedido = Mesa.getMesaByID(mesa);
                Pedido p = mesaPedido.getPedidoByID(pedido);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/itens.jsp");
                request.setAttribute("pedido", p);
                request.setAttribute("mesa", mesaPedido);
                request.setAttribute("itens", p.getItemPedido());
                despachante.forward(request, response);
            }
        } else if ("/adicionar-item.html".equals(request.getServletPath())) {
            Integer mesa = Integer.parseInt(request.getParameter("mesa"));
            Integer pedido = Integer.parseInt(request.getParameter("pedido"));
            Mesa mesaPedido = Mesa.getMesaByID(mesa);
            Pedido p = mesaPedido.getPedidoByID(pedido);
            List<Produto> produtos = Produto.getSampleData();
            request.setAttribute("pedido", p);
            request.setAttribute("mesa", mesaPedido);
            request.setAttribute("produtos", produtos);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/adicionar-item.jsp");
            despachante.forward(request, response);
        } else if ("/editar-item.html".equals(request.getServletPath())) {
            Integer mesa = Integer.parseInt(request.getParameter("mesa"));
            Integer pedido = Integer.parseInt(request.getParameter("pedido"));
            Integer iditem = Integer.parseInt(request.getParameter("item"));
            Mesa mesaPedido = Mesa.getMesaByID(mesa);
            Pedido p = mesaPedido.getPedidoByID(pedido);
            ItemPedido it = p.getItemPedidoById(iditem);
            List<Produto> produtos = Produto.getSampleData();
            request.setAttribute("pedido", p);
            request.setAttribute("mesa", mesaPedido);
            request.setAttribute("produtos", produtos);
            request.setAttribute("item", it);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/editar-item.jsp");
            despachante.forward(request, response);
        } else if ("/excluir-item.html".equals(request.getServletPath())) {
            Integer mesa = Integer.parseInt(request.getParameter("mesa"));
            Integer pedido = Integer.parseInt(request.getParameter("pedido"));
            Integer iditem = Integer.parseInt(request.getParameter("item"));
            Mesa mesaPedido = Mesa.getMesaByID(mesa);
            Pedido p = mesaPedido.getPedidoByID(pedido);
            ItemPedido it = p.getItemPedidoById(iditem);
            boolean remocao = p.removeItemPedidoById(it);
            response.sendRedirect("itens.html?mesaPedido=" + mesaPedido.getId() + "&pedido=" + p.getId());
        } else {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("incluir".equals(request.getParameter("operacao"))) {
            Integer mesa = Integer.parseInt(request.getParameter("mesa"));
            Integer pedido = Integer.parseInt(request.getParameter("pedido"));
            Integer idprod = Integer.parseInt(request.getParameter("produto"));
            Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
            Mesa mesaPedido = Mesa.getMesaByID(mesa);
            Pedido p = mesaPedido.getPedidoByID(pedido);
            Produto produto = Produto.getProdutoByID(idprod);
            ItemPedido it = new ItemPedido(p, produto.clonar(), quantidade);
            p.adicionarItem(it);
            response.sendRedirect("itens.html?mesaPedido=" + mesaPedido.getId() + "&pedido=" + p.getId());

        } else if ("alterar".equals(request.getParameter("operacao"))) {
            Integer mesa = Integer.parseInt(request.getParameter("mesa"));
            Integer pedido = Integer.parseInt(request.getParameter("pedido"));
            Integer idprod = Integer.parseInt(request.getParameter("produto"));
            Integer iditem = Integer.parseInt(request.getParameter("item"));
            Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
            Mesa mesaPedido = Mesa.getMesaByID(mesa);
            Pedido p = mesaPedido.getPedidoByID(pedido);
            Produto produto = Produto.getProdutoByID(idprod);
            ItemPedido it = new ItemPedido(iditem, p, produto, quantidade);
            p.setItemPedidoById(it);
            response.sendRedirect("itens.html?mesaPedido=" + mesaPedido.getId() + "&pedido=" + p.getId());
        }
    }

}
