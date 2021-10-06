package com.company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
	description = "Login Servlet Testing",
	urlPatterns = { "/LoginServlet" },
	initParams= {
			@WebInitParam(name="user", value ="Admin"),
			@WebInitParam(name = "password", value = "Admin@12")
	}
)
public class LoginServlet extends HttpServlet{
	@Override
protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String user = request. getParameter("user") ;
	String password = request. getParameter( "password");
	
	String userID = getServletConfig().getInitParameter("user");
	String password1 = getServletConfig().getInitParameter("password");
		if(userID. equals (user) && password1. equals (password1)) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jp" ).forward(request, response);
		} else {			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter() ;
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}
}
