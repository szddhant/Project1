package com.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.dao.AdminDao;

import javax.servlet.annotation.WebServlet;

import com.bean.HrBean;
import com.dao.HrDao;

@WebServlet("/HrLoginAuthentication")
public class HrLoginAuthentication extends HttpServlet{
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HrBean hrBean = new HrDao().authenticate(email, password);
		RequestDispatcher rd = null;
		
		if(hrBean == null) {
			request.setAttribute("error", "Please Enter valid Credentials");
			rd = request.getRequestDispatcher("hrLogin.jsp");
		}
		else {
			rd = request.getRequestDispatcher("hrHome.jsp");
		}
		rd.forward(request, response);
	}
}
