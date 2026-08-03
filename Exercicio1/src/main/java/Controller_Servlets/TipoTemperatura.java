package Controller_Servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

public class TipoTemperatura extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    String tipoConversao;
    
    tipoConversao = request.getParameter("bTemperatura");
    
    request.setAttribute("tipo", tipoConversao);
    
    RequestDispatcher destino = getServletContext().getRequestDispatcher("/verificaTipoConversao.jsp");
    destino.forward(request, response);
    }
	

}
