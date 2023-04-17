package com.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;

import com.bean.HrBean;
import com.dao.HrDao;

@WebServlet("/HrController")
public class HrController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
//		boolean isError = false;
//		StringBuffer error = new StringBuffer("");
		
		HrBean hrBean = new HrBean();
		
		hrBean.setName(name);
		hrBean.setEmail(email);
		hrBean.setPassword(password);
		hrBean.setPhone(phone);
		
		request.setAttribute("hrDet", hrBean);
		
		RequestDispatcher rd = null;
		HrDao hrDao = new HrDao();
		
		hrDao.addHr(hrBean);
		rd = request.getRequestDispatcher("hrSuccess.jsp");
		
		rd.forward(request, response);
	}
}
