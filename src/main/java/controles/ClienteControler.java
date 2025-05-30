package controles;

import java.util.List;

import dao.ClienteDao;
import modelos.Cliente;

public class ClienteControler {
	
	public List<Cliente> getAll(){
		return ClienteDao.getAll();
	}
	
	public Cliente salvar(Cliente cliente) {
		ClienteDao.insert(cliente);
		return cliente;
	}

	public void excluir(int id) {
		ClienteDao.excluir(id);		
	}
}