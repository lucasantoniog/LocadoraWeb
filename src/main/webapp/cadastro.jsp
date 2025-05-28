<%@page import="controles.ClienteControler"%>
<%@page import="dao.ClienteDao"%>
<%@page import="modelos.Cliente"%>

<%
   String nome = request.getParameter("nome");
   String email = request.getParameter("email");
   String telefone = request.getParameter("telefone");
   
   Cliente cliente = new Cliente();
   cliente.setNome(nome);
   cliente.setEmail(email);
   cliente.setTelefone(telefone);
   
  // ClienteDao clidao = new ClienteDao();
   //ClienteControler cliControler = new ClienteControler(clidao);
   ClienteControler cliControler = new ClienteControler();
   cliControler.salvar(cliente);
   response.sendRedirect("consulta.jsp");
%>