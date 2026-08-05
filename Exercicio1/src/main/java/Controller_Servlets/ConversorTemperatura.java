package Controller_Servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ConversorTemperatura")
public class ConversorTemperatura extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    String tipoConversao;
    double temperatura;
    double temperaturaConvertida=0;

    temperatura = Double.parseDouble(request.getParameter("NumTemperatura"));
    tipoConversao = request.getParameter("bTemperatura");

    if(tipoConversao.equals("Celsius -> Farenheit")) {
        temperaturaConvertida = (temperatura * 1.8) + 32;
    } else if (tipoConversao.equals("Farenheit -> Celsius")) {
        temperaturaConvertida = (temperatura - 32) / 1.8;
    } else if (tipoConversao.equals("Celsius -> Kelvin")) {
        temperaturaConvertida = temperatura + 273.15;
    } else if (tipoConversao.equals("Kelvin -> Celsius")) {
        temperaturaConvertida = temperatura - 273.15;
    } else if (tipoConversao.equals("Farenheit -> Kelvin")) {
        temperaturaConvertida = (temperatura + 459.67) * 5/9;
    } else if (tipoConversao.equals("Kelvin -> Farenheit")) {
        temperaturaConvertida = temperatura * 9/5 - 459.67;
    }
    
    request.setAttribute("tipo", tipoConversao);
    request.setAttribute("temperatura", temperatura);
    request.setAttribute("temperaturaConvertida", temperaturaConvertida);
    
    RequestDispatcher destino = getServletContext().getRequestDispatcher("/resultado.jsp");
    destino.forward(request, response);
    }
	

}
