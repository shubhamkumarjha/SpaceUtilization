package com.sus.allocation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.*;
/*@WebServlet("/addDetailsServlet")*/
public class AddDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StringBuffer sb=new StringBuffer();
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("addDetailsServlet...");
		try {
			String navAction=request.getParameter("navAction");
			if(navAction.equals("getEmployee")){
					StringBuffer data=getEmployeeData(request, response);
					System.out.println("==>"+data);
					response.setContentType("application/json");
					response.getWriter().write(data.toString());
					/*request.setAttribute("options", data);
					RequestDispatcher rd= request.getRequestDispatcher("/home.jsp");
					rd.forward(request, response);*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	StringBuffer getEmployeeData(HttpServletRequest req,HttpServletResponse res){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?","root","root");
			String query="select employee_id,employee_name from employee where isActive=1";
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			sb.append("{");
			while(rs.next()){
				if(rs.getInt(1)!=0 && rs.getString(2)!=null){
					sb.append(rs.getInt(1)+":"+rs.getString(2)+",");
				}
			}
			sb.append("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;
	}

}
