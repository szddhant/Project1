package com.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import com.bean.HrBean;
import com.dao.HrDao;





@WebServlet("/EditHrController")
public class EditHrController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		Integer hr_id = Integer.valueOf(request.getParameter("hr_id"));
		
		
		
		HrBean hrBean = new HrDao().getHrById(hr_id);
	
		request.setAttribute("hrBean", hrBean);
		
		request.getRequestDispatcher("editHr.jsp").forward(request, response);
		
	}
	
public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	Integer hr_id = Integer.parseInt(request.getParameter("hr_id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		System.out.println("editHrController : "+name);
		
		
		HrBean hrBean = new HrBean();
		
		hrBean.setHr_id(hr_id);
		hrBean.setName(name);
		hrBean.setEmail(email);
		hrBean.setPhone(phone);
		hrBean.setPassword(password);
		
		
		new HrDao().editHr(hrBean);
		
		response.sendRedirect("ListHrController");
	}
	
}
