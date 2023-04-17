package com.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.dao.AdminDao;

import com.bean.AdminBean;
import com.dao.AdminDao;

@WebServlet("/adminLoginAuthentication")
public class adminLoginAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AdminBean admin = new AdminDao().authenticate(email, password);
		RequestDispatcher rd = null;
		
		if(admin == null) {
			request.setAttribute("error", "Please Enter valid Credentials");
			rd = request.getRequestDispatcher("adminLogin.jsp");
		}
		else {
			rd = request.getRequestDispatcher("adminHome.jsp");
		}
		rd.forward(request, response);
	}
}
