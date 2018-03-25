package com.servlet.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/HTML");
		
		PrintWriter out= response.getWriter();
		String firstName= request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		
		out.println("<h3> Reading Query String data using getPatameter method </h3>  ");
		out.println("<div>");
		out.println("<p>First Name: "+firstName+"</p>");
		out.println("<p>Last Name: "+lastName+"</p>");
		out.println("</div>");
		
		//using enumeration getting query values...
		
		Enumeration<String> paramNames= request.getParameterNames();
		
		out.println("<div>");
		
		while(paramNames.hasMoreElements()) {
			
			String paramName= paramNames.nextElement();
			String paramValues= request.getParameter(paramName);
			out.println("<p>"+paramName +":"+ paramValues +"</p>" );
			
		}
		
		out.println("</div>");
		
		
		Map<String, String[]> paramMap= request.getParameterMap();
		Set<String> paramNameSet= paramMap.keySet();
		
		out.println("<h3>Query String data using the Map method and keySets() </h3>");
		out.println("<div>");
		
		for(String paramName : paramNameSet) {
			
			String[] paramValues= paramMap.get(paramName);
			out.println("<p>"+paramName+": ");
			
			for(int i=0; i < paramValues.length; i++) {
				out.println(paramValues[i]+"</p>");
			}
			
			
		}
		out.println("</div>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
