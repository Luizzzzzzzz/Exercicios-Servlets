package Controller_Servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/TipoTemperatura")
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
