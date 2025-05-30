<%@page import="modelos.Veiculo"%>
<%@page import="dao.VeiculoDao"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Ve�culos</title>
</head>
<body>
    <h1>Lista de Ve�culos</h1>
    <a href="index.html"> Home </a> 
    <a href="cadastroVeiculo.html">Cadastrar novo ve�culo</a>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Modelo</th>
            <th>Marca</th>
            <th>Placa</th>
            <th>Ano</th>
            <th>Pre�o da Di�ria</th>
        </tr>
        <%
            List<Veiculo> veiculos = VeiculoDao.getAll();
            for (Veiculo v : veiculos) {
                out.print("<tr>");
                out.print("<td>" + v.getId() + "</td>");
                out.print("<td>" + v.getModelo() + "</td>");
                out.print("<td>" + v.getMarca() + "</td>");
                out.print("<td>" + v.getPlaca() + "</td>");
                out.print("<td>" + v.getAno() + "</td>");
                out.print("<td>" + v.getPrecoDiaria() + "</td>");
                out.print("</tr>");
            }
        %>
    </table>
</body>
</html>