<%@ page import="controles.ClienteControler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		int id = Integer.parseInt(request.getParameter("id"));
		ClienteControler cliControler = new ClienteControler();
		cliControler.excluir(id);
		response.sendRedirect("consulta.jsp");
		%>
</body>
</html>