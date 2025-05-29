package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;
import utils.ConexaoDB;

public class ClienteDao {

	public static Cliente getClienteById(int id) {
		Cliente cliente = new Cliente();
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "select * from tb_clientes where id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
			}
			
			rs.close();
			stm.close();
			con.close();			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return cliente;
	}
	
	public static void alterar(Cliente clienteAlterado) {
	    try {
	        Connection con = ConexaoDB.getConexao();
	        String sql = "update tb_clientes set nome = ?, email = ?, telefone = ? where id = ?";
	        PreparedStatement stm = con.prepareStatement(sql);
	        stm.setString(1, clienteAlterado.getNome());
	        stm.setString(2, clienteAlterado.getEmail());
	        stm.setString(3, clienteAlterado.getTelefone());
	        stm.setInt(4, clienteAlterado.getId());

	        stm.executeUpdate();

	        stm.close();
	        con.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e.getMessage());
	    }
	}


	public static Cliente insert(Cliente cliente) {
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "insert into tb_clientes(nome, email, telefone)" + "values(?,?, ?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getEmail());
			stm.setString(3, cliente.getTelefone());
			stm.execute();

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return cliente;
	}

	public static List<Cliente> getAll() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Connection con = ConexaoDB.getConexao();

			String sql = "select * from tb_clientes";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				clientes.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email"),
						rs.getString("telefone")));
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return clientes;
	}
}
