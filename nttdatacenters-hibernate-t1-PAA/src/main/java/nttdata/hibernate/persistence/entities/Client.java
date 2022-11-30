package nttdata.hibernate.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity Class Cliente.
 */
@Entity
@Table(name = "TABLA_CLIENTE")
public class Client extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long clienteID;
	private String nombre;
	private String apellido;
	private String dni;
	
	/**
	 * @return cliente ID
	 */
	@Transient
	@Override
	public Long getId() {
		return clienteID;
	}

	/**
	 * @return cliente ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENTE_ID", unique = true)
	public Long getIdCliente() {
		return this.clienteID;
	}
	
	/**
	 * @param establecer clienteID
	 */
	public void setIdCliente(Long clienteID) {
		this.clienteID = clienteID;
	}
	
	/**
	 * @return nombre
	 */
	@Column(name = "NOMBRE", nullable = false)
	public String getName() {
		return nombre;
	}

	/**
	 * @param establecer nombre
	 */
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return apellido
	 */
	@Column(name = "APELLIDO")
	public String getSurname() {
		return apellido;
	}

	/**
	 * @param establecer apellido
	 */
	public void setSurname(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * @return dni
	 */
	@Column(name = "DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	/**
	 * @param establecer dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
}
