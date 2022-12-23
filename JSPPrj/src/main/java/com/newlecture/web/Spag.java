package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {
		
		int num = 0;
		
		String num_ = request.getParameter("n");
		if(num_!=null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num%2==0)
			result = "짝수";
		else
			result = "홀수";
		
		//${result}
		request.setAttribute("result", result);
		
		//${names[0]}
		String[] names = {"newlec","Dragon"};
		request.setAttribute("names",names);

		//${notice.title }
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title","EL GOOD");
		request.setAttribute("notice",notice);
		
		//redirect
		//forward
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("spag.jsp");
		dispatcher.forward(request, response);
	}
}