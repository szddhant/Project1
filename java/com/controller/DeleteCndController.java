package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CndDao;

@WebServlet("/DeleteCndController")
public class DeleteCndController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		Integer cnd_id = Integer.parseInt(request.getParameter("cnd_id"));
		new CndDao().deleteCnd(cnd_id);
		
		response.sendRedirect("ListCndController");
	}
}
