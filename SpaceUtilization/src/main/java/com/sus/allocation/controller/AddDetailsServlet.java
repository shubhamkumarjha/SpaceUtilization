package com.sus.allocation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/*@WebServlet("/addDetailsServlet")*/
public class AddDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StringBuffer sb=null;
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
			//System.out.println("======>"+navAction);
			if(navAction.equals("getEmployee")){
					StringBuffer data=getEmployeeData(request, response);
					response.getWriter().write(data.toString());
			}
			System.out.println("=>"+sb);
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
			while(rs.next()){
				sb.append("select.options.add( new Option(\""+rs.getString(1)+"\",\""+rs.getString(2)+"\"));");
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;
	}

}
