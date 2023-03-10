package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {
	//403 URL, 메서드 둘 다 있지만 권한이 없을 경우 발생하는 오류
	//404 URL 이 없어서 발생하는 오류
	//405 URL은 있지만 받을 메서드가 없을 경우 발생하는 오류
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {
	
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		String ids_ = request.getParameter("ids");
		String[] ids = ids_.trim().split(" ");
		
		NoticeService service = new NoticeService();
		
		switch(cmd) {
		case "일괄공개" :
			for(String openId : openIds)
				System.out.printf("open id : %s\n", openId);
			
			List<String> oids = Arrays.asList(openIds);
			List<String> cids = new ArrayList(Arrays.asList(ids));
			cids.removeAll(oids);
			
			//Transaction 처리 Transaction = 한번에 이루어질 수 있는 업무 단위
			service.pubNoticeAll(oids,cids); //UPDATE NOTICE SET PUB=1 WHERE ID IN(...);
			
			break;
		
		
		case "일괄삭제" :

			int[] ids1 = new int[delIds.length];
			for(int i = 0; i<delIds.length; i++)
				ids1[i] = Integer.parseInt(delIds[i]);
			
			int result = service.deleteNoticeAll(ids1);
			break;
		}	
		
		response.sendRedirect("list");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {
		//list?f=title&q=a
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String field = "title";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page =1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		//값이 전달되지 않았을 경우를 항상 상정하고 임시변수와 기본값의 설정을 조심해아 한다.
		
		NoticeService service = new NoticeService();
		List<NoticeView> list = service.getNoticeList(field, query, page);
		int count = service.getNoticeCount(field, query);		
		
		request.setAttribute("list", list);
		request.setAttribute("count",count);
		
		request
		.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp")
		.forward(request, response);


	}
}

