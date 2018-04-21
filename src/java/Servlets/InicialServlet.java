package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelos.Mesa;

@WebServlet(name = "InicialServlet", urlPatterns = {"/index.html","/mesas.html"})
public class InicialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/index.html".equals(request.getServletPath())) {
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
            despachante.forward(request, response);
        }else if("/mesas.html".equals(request.getServletPath())){
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/mesas.jsp");
            request.setAttribute("mesas", Mesa.getSampleDataMesa());
            despachante.forward(request, response);
        }
    }

}
