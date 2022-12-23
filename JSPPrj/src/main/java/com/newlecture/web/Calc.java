package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse resp)
					throws ServletException
					, IOException {
		ServletContext app = req.getServletContext();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		
		if(op.equals("=")) {
			int x = (Integer)app.getAttribute("value");
			int y = v;
			String operator = (String)app.getAttribute("op");
			int result =0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			resp.getWriter().printf("result is %d\n", result);
		}
	
		else {
			app.setAttribute("value", v);
			app.setAttribute("op", op);
		}
	}
}