package com.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import com.bean.HrBean;
import com.dao.HrDao;

@WebServlet("/DeleteHrController")
public class DeleteHrController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		Integer hr_id = Integer.parseInt(request.getParameter("hr_id"));
		new HrDao().deleteHr(hr_id);
		
		response.sendRedirect("ListHrController");
	}
}
