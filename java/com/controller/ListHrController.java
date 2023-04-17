package com.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import com.bean.HrBean;
import com.dao.HrDao;

import java.util.ArrayList;

@WebServlet("/ListHrController")
public class ListHrController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ArrayList<HrBean> hrbean = new HrDao().getAllHr();
		request.setAttribute("hrDet", hrbean);
		
		request.getRequestDispatcher("listHr.jsp").forward(request, response);
	}
	
}
