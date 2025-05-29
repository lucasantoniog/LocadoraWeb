package dao;

import java.sql.*;
import java.util.*;
import modelos.Veiculo;
import utils.ConexaoDB;

public class VeiculoDao {

    public static void insert(Veiculo veiculo) {
        try {
            Connection con = ConexaoDB.getConexao();
            String sql = "INSERT INTO tb_veiculos (modelo, marca, placa, ano) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, veiculo.getModelo());
            stm.setString(2, veiculo.getMarca());
            stm.setString(3, veiculo.getPlaca());
            stm.setInt(4, veiculo.getAno());
            stm.execute();

            stm.close();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<Veiculo> getAll() {
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            Connection con = ConexaoDB.getConexao();
            String sql = "SELECT * FROM tb_veiculos";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                veiculos.add(new Veiculo(
                    rs.getInt("id"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getString("placa"),
                    rs.getInt("ano"),
                    rs.getDouble("precoDiaria")
                ));
            }

            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return veiculos;
    }
}