<%@page import="dao.ClienteDao"%>
<%@page import="modelos.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualização de Cadastro</title>
</head>
<body>
	<%
	if ("POST".equals(request.getMethod())) {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		Cliente cli = new Cliente();
		cli.setId(Integer.parseInt(id));
		cli.setNome(nome);
		cli.setEmail(email);
		cli.setTelefone(telefone);

		ClienteDao.alterar(cli);
		response.sendRedirect("./consulta.jsp");
		return;
	}
	%>

	<%
	String id = request.getParameter("id");
	Cliente cliente = ClienteDao.getClienteById(Integer.parseInt(id));
	%>
	<div class="container">
		<h1>
			Editar cliente:
			<%
		out.print(id);
		%>
		</h1>
		<div>
			<a href="index.html"> Home </a> 
			<a href="cadastro.html"> Cadastro </a>
			<a href="consulta.jsp"> Consulta </a>
		</div>
		<form id="fcad" action="editar.jsp" method="POST">
		<input type="hidden" name="id" value="<%= cliente.getId() %>" />
		
			<label for="nome">Informe seu nome</label> 
				<input type="text" id="nome" name="nome" placeholder="EX: maria" value="<%out.print(cliente.getNome());%>" />
			<label for="email">Informe seu email</label>
				<input type="email" id="email" name="email" placeholder="EX: maria@gmail.com" value="<%out.print(cliente.getEmail());%>" /> 
			<label for="telefone">Informe seu telefone</label>
				<input type="tel" id="telefone" name="telefone" placeholder="EX: (99)999-9999" value="<%out.print(cliente.getTelefone());%>" /> 
				<input type="button" value="salvar" onclick="gravar()" />
		</form>
	</div>
	<script>
	    function gravar(){
	    	var nome = document.getElementById("nome")
	    	if(nome.value === ""){
	    		alert("O nome deve ser informado")
	    		nome.focus()
	    		return
	    	}
	    	
	    	var email = document.getElementById("email")
	    	if(email.value === ""){
	    		alert("O email deve ser informado")
	    		email.focus()
	    		return
	    	}
	    	
	    	var telefone = document.getElementById("telefone")
	    	if(telefone.value === ""){
	    		alert("O telefone deve ser informado")
	    		telefone.focus()
	    		return
	    	}	    	
	    	document.getElementById("fcad").submit()	    	
	    }
	    
	</script>
</body>
</html>