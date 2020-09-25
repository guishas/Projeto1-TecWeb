package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")

public class Remove extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String id = request.getParameter("id");
			String[] newID = id.split(" ", 2);
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<form method='post'>");
			out.println("ID à ser removido: " + newID[1] + "<br>");
			out.println("<input type='submit' value='Deletar'>");
			out.println("</form>");
			out.println("<body><html>");
		}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			DAO dao = new DAO();
			String id = request.getParameter("id");
			String[] newID = id.split(" ", 2);
			dao.remove(Integer.valueOf(newID[1]));
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("REMOVIDO!");
			out.println("<form action='http://localhost:8080/projeto1final/cria'><input type='submit' value='Ir para Criar'/></form>");
			out.println("<form action='http://localhost:8080/projeto1final/lista'><input type='submit' value='Ir para Lista'/></form>");
			out.println("</body></html>");
			dao.close();
		}
}