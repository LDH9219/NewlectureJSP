package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi") //Annotation : 클래스나 메서드에 붙여지는 주석
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		  PrintWriter out = response.getWriter();
		  
		  String temp = request.getParameter("cnt");
		  
		  int cnt = 5;
		  
		  if(temp != null && !temp.equals("")) {
			  cnt = Integer.parseInt(temp);
		  }
		  
		  for(int i = 0; i<cnt; i++){
		  out.println((1+i)+":안녕 Servlet <br />");
		  }
	}
}