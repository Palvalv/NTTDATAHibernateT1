package nttdata.hibernate.persistence.dao.implementations;

import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.interfaces.ClienteDaoI;
import nttdata.hibernate.persistence.entities.Client;

/**
 * Implementacion Cliente DAO.
 */
public class ClienteDaoImpl extends CommonDaoImpl<Client> implements ClienteDaoI {
	
	/**
	 * Conexion a Base de Datos.
	 **/
	private Session session;

	/**
	 * Metodo constructor.
	 */
	public ClienteDaoImpl(Session sesion) {
		super(sesion);
		this.session = sesion;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByNameAndSurname(final String nombre, final String apellido) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		/**
		 * Buscamos a los clientes por su nombre y apellido.
		 */
		return session.createQuery("FROM Client WHERE nombre = " + nombre + " and apellido = " + apellido).list();
		
	}

}
