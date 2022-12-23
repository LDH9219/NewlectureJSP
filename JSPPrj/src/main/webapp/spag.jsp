<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<%
pageContext.setAttribute("aa", "hello");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("result") %>입니다.
	${result}
	${names[0]}
	${notice.title }
	${aa }
</body>
</html>