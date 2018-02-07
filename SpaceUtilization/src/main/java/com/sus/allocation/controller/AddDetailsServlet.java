package com.sus.allocation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*@WebServlet("/addDetailsServlet")*/
public class AddDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addDetailsServlet...");
		try {
			String navAction=request.getParameter("navAction");
			System.out.println("======>"+navAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
