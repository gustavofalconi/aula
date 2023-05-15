package br.edu.ifsp.spo;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/oi", "/ola"})
public class Main extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<HTML><BODY>");
		out.println("<P>Hello World!<P>");
		out.println("</HTML></BODY>");
		out.close();
	}
}
