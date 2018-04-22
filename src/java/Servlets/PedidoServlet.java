package Servlets;

import Modelos.Mesa;
import Modelos.Pedido;
import java.io.IOException;
import java.time.LocalTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidoServlet", urlPatterns = {"/pedidos.html", "/adicionar-pedidos.html","/fechar-pedido.html"})
public class PedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/pedidos.html".equals(request.getServletPath())) {
            if (request.getParameter("mesa") != null) {
                Integer mesa = Integer.parseInt(request.getParameter("mesa"));
                Mesa mesaPedido = Mesa.getMesaByID(mesa);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/pedidos.jsp");
                request.setAttribute("pedidos", mesaPedido.getPedido());
                request.setAttribute("mesaPedido", mesaPedido);
                despachante.forward(request, response);
            } else {
                response.sendError(404);
            }
        } else if ("/adicionar-pedidos.html".equals(request.getServletPath())) {
            if (request.getParameter("mesaPedido") != null) {
                Integer mesa = Integer.parseInt(request.getParameter("mesaPedido"));
                Mesa mesaPedido = Mesa.getMesaByID(mesa);
                mesaPedido.gerarPedidoNovo();
                response.sendRedirect("pedidos.html?mesa=" + mesaPedido.getId());
            } else {
                response.sendError(404);
            } 
        } else if ("/fechar-pedido.html".equals(request.getServletPath())) {
            Integer mesa = Integer.parseInt(request.getParameter("mesaPedido"));
            Mesa mesaPedido = Mesa.getMesaByID(mesa);
            Integer pedido = Integer.parseInt(request.getParameter("pedido"));
            Pedido p = mesaPedido.getPedidoByID(pedido);
            if (!p.isFechado()) {
                p.setFechado(true);
                p.setHora_fechamento(LocalTime.now());
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/resumo.jsp");
                request.setAttribute("pedido", p);
                request.setAttribute("mesaPedido", mesaPedido);
                despachante.forward(request, response);
            } else {
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/resumo.jsp");
                request.setAttribute("pedido", p);
                request.setAttribute("mesaPedido", mesaPedido);
                despachante.forward(request, response);
            }
        }

    }
}
