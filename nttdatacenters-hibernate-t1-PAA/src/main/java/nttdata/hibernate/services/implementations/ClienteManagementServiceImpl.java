package nttdata.hibernate.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.implementations.ClienteDaoImpl;
import nttdata.hibernate.persistence.dao.interfaces.ClienteDaoI;
import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.services.interfaces.ClienteManagementServiceI;

/**
 * Implementacion Servicio Cliente.
 */
public class ClienteManagementServiceImpl implements ClienteManagementServiceI {

	private ClienteDaoI clienteDao;

	/**
	 * Metodo constructor.
	 */
	public ClienteManagementServiceImpl(final Session sesion) {
		this.clienteDao = new ClienteDaoImpl(sesion);
	}

	@Override
	public void insertNewCliente(Client nuevoCliente) {
		
		/**
		 * Comprobacion de existencia y nulidad.
		 */
		if (nuevoCliente != null && nuevoCliente.getId() == null) {

		/**
		 * Insertar nuevo cliente.
		 */
			clienteDao.insert(nuevoCliente);
		}
	}

	@Override
	public void updateCliente(Client actualizarCliente) {
		
		/**
		 * Comprobacion de existencia y nulidad.
		 */
		if (actualizarCliente != null && actualizarCliente.getId() != null) {

		/**
		 * Actualizar cliente.
		 */
			clienteDao.update(actualizarCliente);
		}

	}

	@Override
	public void deleteCliente(Client eliminarCliente) {
		
		/**
		 * Comprobacion de existencia y nulidad.
		 */
		if (eliminarCliente != null && eliminarCliente.getId() != null) {

		/**
		 * Eliminar cliente.
		 */
			clienteDao.delete(eliminarCliente);
		}

	}

	@Override
	public Client searchById(Long clienteID) {
		
		Client cliente = null;

		/**
		 * Comprobacion de nulidad.
		 */
		if (clienteID != null) {

		/**
		 * Localizacion cliente por ID.
		 */
			cliente = (Client) clienteDao.searchById(clienteID);
		}

		return cliente;
	}

	@Override
	public List<Client> searchAll() {
		
		List<Client> clienteList = new ArrayList<>();

		/**
		 * Localizacion de clientes.
		 */
		clienteList = clienteDao.searchAll();

		return clienteList;
	}

	@Override
	public List<Client> searchByNameAndSurname(String nombrePattern, String apellidoPattern) {
		
		List<Client> clienteList = new ArrayList<>();

		/**
		 * Comprobacion de nulidad.
		 */
		if (StringUtils.isNotBlank(nombrePattern) && StringUtils.isNotBlank(apellidoPattern)) {

			/**
			 * Localizacion de clientes por nombre y apellido.
			 */
			clienteList = clienteDao.searchByNameAndSurname(nombrePattern, apellidoPattern);
		}

		return clienteList;
	}

}
