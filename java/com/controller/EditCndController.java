package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CndBean;
import com.dao.CndDao;

@WebServlet("/EditCndController")
public class EditCndController extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		Integer cnd_id = Integer.valueOf(request.getParameter("cnd_id"));
		
		
		
		CndBean cndBean = new CndDao().getCndById(cnd_id);
	
		request.setAttribute("cndBean", cndBean);
		
		request.getRequestDispatcher("editCnd.jsp").forward(request, response);
		
	}

public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	Integer cnd_id = Integer.parseInt(request.getParameter("cnd_id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String branch = request.getParameter("branch");
		String exp = request.getParameter("exp");
		String resume = request.getParameter("resume");
		
		
		
		CndBean cndBean = new CndBean();
		
		cndBean.setCnd_id(cnd_id);
		cndBean.setName(name);
		cndBean.setEmail(email);
		cndBean.setPhone(phone);
		cndBean.setBranch(branch);
		cndBean.setExp(exp);
		cndBean.setResume(resume);
		
		
		new CndDao().editCnd(cndBean);
		
		response.sendRedirect("ListCndController");
	}
}
