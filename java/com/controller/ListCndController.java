package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CndBean;
import com.dao.CndDao;

@WebServlet("/ListCndController")
public class ListCndController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ArrayList<CndBean> cndBean = new CndDao().getAllCnd();
		request.setAttribute("cndDet", cndBean);
		
		request.getRequestDispatcher("listCnd.jsp").forward(request, response);
	}
}
