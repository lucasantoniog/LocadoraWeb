<%@ page import="controles.VeiculoControler" %>
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
VeiculoControler veiControler = new VeiculoControler();
veiControler.excluir(id);
response.sendRedirect("consulta.jsp");
%>
%>
</body>
</html>