package com.servlet.demos;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName= request.getParameter("userName");
		String passwd= request.getParameter("passwd");
		String gender= request.getParameter("gender");
		String[] hobbies= request.getParameterValues("hobbies");
		String country= request.getParameter("countries");
		String[] languages= request.getParameterValues("languages");
		 
		response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		out.println("<div>");
		out.println("<p>Username : "+userName+"</p>");
		out.println("<p>Password : "+passwd+"</p>");
		out.println("<p>Sex : "+gender+"</p>");
		out.println("<p>Hobbies : </p>");
		
		for(int i=0; i< hobbies.length; i++) {
			out.println(hobbies[i]+"<br>");
		}
		
		out.println("<p>Country : "+country+"</p>");
		out.println("<p>Languages known : </p>");
		for(int i=0; i< languages.length; i++) {
			out.println(languages[i]+"<br>");	
	}
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out= response.getWriter();
			try {
				
				
			Class.forName("oracle.jdbc.driver.OracleDriver");
				 
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			
			int id= Integer.parseInt(request.getParameter("id"));
			String name= request.getParameter("name");
			double salary= Double.parseDouble(request.getParameter("salary"));
			
			String sql= "Insert into testpoc values(?,?,?)";
			
			PreparedStatement psmt= conn.prepareStatement(sql);
			
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setDouble(3, salary);
			
			int res= psmt.executeUpdate();
			response.setContentType("text/html");
			
			
			
			if(res==1) {
			out.println("<h3> This is for the POST method </h3>");
			out.println("<div>");
			out.println("<p>ID : "+id+"</p>");
			out.println("<p>Name : "+name+"</p>");
			out.println("<p>Salary : "+salary+"</p>");
		
			out.println("</div>");
			}
			else {
				out.println("<p>Error</p>");
			}
			psmt.close();
			conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
