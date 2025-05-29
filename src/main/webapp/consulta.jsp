<%@page import="modelos.Cliente"%>
<%@page import="controles.ClienteControler"%>
<%@page import="dao.ClienteDao"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href="./estilos/estilos.css" />
</head>
<body>
	<div class="container">
		<h1 class="text-center">Consulta de Clientes</h1>
		<div>
			<a href="index.html"> Home </a> <a href="cadastro.html"> Cadastro
			</a> <a href="consulta.jsp"> Consulta </a>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Editar</th>
				</tr>
			<tbody>
				<%
				// ClienteDao clidao = new ClienteDao();
				// ClienteControler cliControler = new ClienteControler(clidao);
				ClienteControler cliControler = new ClienteControler();
				List<Cliente> clientes = cliControler.getAll();
				for (Cliente c : clientes) {
					out.print("<tr>");
					out.print("<td>" + c.getId() + "</td>");
					out.print("<td>" + c.getNome() + "</td>");
					out.print("<td>" + c.getEmail() + "</td>");
					out.print("<td>" + c.getTelefone() + "</td>");
					out.print("<td><a href='./editar.jsp?id="+c.getId()+"'>editar</a></td>");
					out.print("</tr>");
				}
				%>
			</tbody>
			</thead>
		</table>
	</div>
</body>
</html>