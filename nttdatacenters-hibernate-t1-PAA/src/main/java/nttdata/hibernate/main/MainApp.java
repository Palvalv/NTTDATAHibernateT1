package nttdata.hibernate.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.services.implementations.ClienteManagementServiceImpl;
import nttdata.hibernate.services.interfaces.ClienteManagementServiceI;

public class MainApp {
	
	public static void main(String[] args) {
		
		/** 
		 * La sesión se abre.
		 */
		final Session session = HibernateUtil.getSessionFactory().openSession();

		/** 
		 * Los servicios se inicializan.
		 */
		final ClienteManagementServiceI clientService = new ClienteManagementServiceImpl(session);

		/**
		 * El cliente de muestra se evalúa.
		 */
		final String updatedUser = "PABLOAA";
		final Date updatedDate = new Date();
		final Client clientemuestra = new Client();
		clientemuestra.setDni("11111111X");
		clientemuestra.setName("Nombre");
		clientemuestra.setSurname("Apellido");
		clientemuestra.setUpdatedUser(updatedUser);
		clientemuestra.setUpdatedDate(updatedDate);
		clientService.insertNewCliente(clientemuestra);	
		clientemuestra.setName("NombreCambiado");		
		clientService.updateCliente(clientemuestra);
		clientemuestra.setUpdatedUser(updatedUser);
		clientemuestra.setUpdatedDate(updatedDate);
		
		final Client clienteEliminar = new Client();
		clienteEliminar.setDni("11111111X");
		clienteEliminar.setName("eliminar");
		clienteEliminar.setSurname("eliminado");
		clientemuestra.setUpdatedUser(updatedUser);
		clientemuestra.setUpdatedDate(updatedDate);
		clientService.deleteCliente(clienteEliminar);
		clientemuestra.setUpdatedUser(updatedUser);
		clientemuestra.setUpdatedDate(updatedDate);
		
		/**
		 * Consultas con JPA Criteria.
		 */
		List<Client> listaClientes1 = clientService.searchByNameAndSurname("C%", "P%");

		for (final Client client : listaClientes1) {
			System.out.println(client.getName() + ", " + client.getSurname() + ", " + client.getDni());
		}
		
		List<Client> listaClientes2 = clientService.searchAll();

		for (final Client client : listaClientes2) {
			System.out.println(client.getName() + ", " + client.getSurname() + ", " + client.getDni());
		}
		
		Long id = (long) 1;
		Client listaClientes3 = clientService.searchById(id);
		System.out.println(listaClientes3);
		
		/**
		 * La sesion se cierra.
		 */
		session.close();
	}
}
