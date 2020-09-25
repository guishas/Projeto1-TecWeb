package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cria")
public class Cria extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>Criar um Post-it</h1>");
			out.println("<form method='post'>");
			out.println("Título: <input type='text' name='title'><br>");
			out.println("Descrição: <input type='text' name='description' maxlenght='200'><br>");
			out.println("<input type='submit' value='Criar'>");
			out.println("</form>");
			out.println("<body><html>");
		}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
			
			
			DAO dao = null;
			dao = new DAO();
			Post post = new Post(request.getParameter("title"), request.getParameter("description"));
			
			dao.adiciona(post);
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println(post.getTitle() + " ADICIONADO!");
			out.println("<form action='http://localhost:8080/projeto1final/cria'><input type='submit' value='Ir para Criar'/></form>");
			out.println("<form action='http://localhost:8080/projeto1final/lista'><input type='submit' value='Ir para Lista'/></form>");
			out.println("</body></html>");
			dao.close();
	}
}
