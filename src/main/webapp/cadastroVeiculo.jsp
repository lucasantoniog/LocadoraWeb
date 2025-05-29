<%@page import="modelos.Veiculo"%>
<%@page import="dao.VeiculoDao"%>
<%
    String modelo = request.getParameter("modelo");
    String marca = request.getParameter("marca");
    String placa = request.getParameter("placa");
    int ano = Integer.parseInt(request.getParameter("ano"));
    double precoDiaria = Double.parseDouble(request.getParameter("precoDiaria"));

    Veiculo veiculo = new Veiculo();
    veiculo.setModelo(modelo);
    veiculo.setMarca(marca);
    veiculo.setPlaca(placa);
    veiculo.setAno(ano);
    veiculo.setPrecoDiaria(precoDiaria);

    VeiculoDao.insert(veiculo);
    response.sendRedirect("consultaVeiculos.jsp");
%>