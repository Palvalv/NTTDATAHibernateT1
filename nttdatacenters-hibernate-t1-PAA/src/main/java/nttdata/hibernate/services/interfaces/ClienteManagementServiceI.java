package nttdata.hibernate.services.interfaces;

import java.util.List;

import nttdata.hibernate.persistence.entities.Client;

/**
 * Interfaz Servicio Cliente.
 */
public interface ClienteManagementServiceI {
	
	/**
	 * Insertar nuevo cliente.
	 * @param nuevoCliente
	 */
	public void insertNewCliente(final Client nuevoCliente);

	/**
	 * Actualizar cliente existente.
	 * @param actualizarCliente
	 */
	public void updateCliente(final Client actualizarCliente);

	/**
	 * Eliminar cliente existente.
	 * @param eliminarCliente
	 */
	public void deleteCliente(final Client eliminarCliente);

	/**
	 * Obtener cliente por ID.
	 * @param clienteID
	 */
	public Client searchById(final Long clienteID);

	/**
	 * Obtener todos los clientes.
	 * @return List<Cliente>
	 */
	public List<Client> searchAll();

	/**
	 * Obtener clientes por nombre y apellido.
	 * @param nombrePattern
	 * @param apellidoPattern
	 * @return List<Cliente>
	 */
	public List<Client> searchByNameAndSurname(final String nombrePattern, final String apellidoPattern);
}
