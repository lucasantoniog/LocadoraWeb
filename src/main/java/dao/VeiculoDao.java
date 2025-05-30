package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Veiculo;
import utils.ConexaoDB;

public class VeiculoDao {
	
	public static Veiculo getVeiculoById(int id) {
		Veiculo veiculo = new Veiculo();
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "select * from tb_veiculos where id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				veiculo.setId(rs.getInt("id"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setPrecoDiaria(rs.getDouble("precoDiaria"));
			}
			
			rs.close();
			stm.close();
			con.close();			
		} catch (SQLException e) {
			
			throw new RuntimeException(e.getMessage());
		}
		return veiculo;
	}

    public static void insert(Veiculo veiculo) {
        try {
            Connection con = ConexaoDB.getConexao();
            String sql = "INSERT INTO tb_veiculos (modelo, marca, placa, ano, precoDiaria) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, veiculo.getModelo());
            stm.setString(2, veiculo.getMarca());
            stm.setString(3, veiculo.getPlaca());
            stm.setInt(4, veiculo.getAno());
            stm.setDouble(4, veiculo.getPrecoDiaria());
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
    
    public static void excluir(int id) {
	    try {
	        Connection con = ConexaoDB.getConexao();
	        String sql = "DELETE FROM tb_veiculos WHERE id = ?";
	        PreparedStatement stm = con.prepareStatement(sql);
	        stm.setInt(1, id);
	        stm.executeUpdate();
	        stm.close();
	        con.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e.getMessage());
	    }
	}
    
}