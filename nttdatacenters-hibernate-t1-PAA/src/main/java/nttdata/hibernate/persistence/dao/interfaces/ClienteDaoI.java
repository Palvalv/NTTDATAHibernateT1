package nttdata.hibernate.persistence.dao.interfaces;

import java.util.List;

import nttdata.hibernate.persistence.entities.Client;

/**
 * Interfaz Cliente DAO.
 */
public interface ClienteDaoI extends CommonDaoI<Client>{
	/**
	 * Localiza a los clientes por nombre y apellido.
	 * @param nombrePattern
	 * @param apellidoPattern
	 * @return List<Client>
	 */
	public List<Client> searchByNameAndSurname(final String nombrePattern, final String apellidoPattern);
	
}
