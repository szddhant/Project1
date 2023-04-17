package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CndBean;
import com.dao.CndDao;

@WebServlet("/CndController")
public class CndController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String exp = request.getParameter("exp");
		String resume = request.getParameter("resume");
		String branch = request.getParameter("branch");
		String[] lang = request.getParameterValues("lang");
		String[] tech = request.getParameterValues("tech");
		String[] db = request.getParameterValues("db");
		
		CndBean cndBean = new CndBean();
		
		
		
		cndBean.setName(name);
		cndBean.setEmail(email);
		cndBean.setPhone(phone);
		cndBean.setExp(exp);
		cndBean.setResume(resume);
		cndBean.setBranch(branch);
		
		//request.setAttribute("cndDet", cndBean);
		
		RequestDispatcher rd = null;
		CndDao cndDao = new CndDao();
		
		int cnd_id = cndDao.addCnd(cndBean);
		
		cndDao.addLang(cnd_id, lang);
		cndDao.addTech(cnd_id, tech);
		cndDao.addDb(cnd_id, db);
		
		rd = request.getRequestDispatcher("cndSuccess.jsp");
		
		rd.forward(request, response);
	}
}
