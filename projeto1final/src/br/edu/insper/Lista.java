package br.edu.insper;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import br.edu.insper.DAO;
import br.edu.insper.Post;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lista")

public class Lista extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
	
		throws ServletException, IOException {
			DAO dao = new DAO();
			List<Post> posts = dao.getLista();
			
			request.setAttribute("posts", posts);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cabecalho.jsp");
			dispatcher.forward(request, response);

			dao.close();
		}
}
